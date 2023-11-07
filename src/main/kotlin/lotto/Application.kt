package lotto

fun main() {
    val inputMoney =lottoMoneyInput()
    val count = lottoCnt(inputMoney)
    val lottoList = lottoNumberLimit(count)
    lottoNumberPrint(count, lottoList)

    val lottoNumber = lottoNumberChoose()
    println("당첨된 로또 번호: $lottoNumber")

}
fun lottoMoneyInput(): Int {
    println("구입금액을 입력해 주세요.")
    val inputMoney = readLine()!!.toInt()
    if (inputMoney % 1000 != 0) {
        throw IllegalArgumentException("1000원 단위로 입력해 주세요.")
    }
    return inputMoney
}

fun lottoCnt(inputMoney: Int): Int {
    return inputMoney / 1000
}
fun lottoNumberLimit(count: Int): List<List<Int>> {
    val comLottoList = mutableListOf<List<Int>>()
    val randomNumber = java.util.Random()
    repeat(count) {
        val lotto = mutableSetOf<Int>()
        while (lotto.size < 6) {
            val num = randomNumber.nextInt(45) + 1
            lotto.add(num)
        }
        comLottoList.add(lotto.toList())
    }
    return comLottoList
}
fun lottoNumberPrint(lottoCount: Int, lottoList: List<List<Int>>) {
    println("$lottoCount 개를 구매했습니다.")
    for (lotto in lottoList) {
        println(lotto.sorted())
    }
}

fun lottoNumberChoose(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val lottoNumber = readLine()!!.split(",").map { it.toInt() }
    if (lottoNumber.size != 6) {
        throw IllegalArgumentException("6개의 번호를 입력해 주세요.")
    }
    return lottoNumber
}

