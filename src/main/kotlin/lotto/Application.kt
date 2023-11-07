package lotto

fun main() {
    val inputMoney =lottoMoneyInput()
    val count = lottoCnt(inputMoney)
    val generatedLottoList = lottoNumberLimit(count)

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
        println("생성된 로또 번호: $lotto")
        comLottoList.add(lotto.toList())
    }
    return comLottoList
}
