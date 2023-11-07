package lotto

fun main() {
    val inputMoney =lottoMoneyInput()
    val count = lottoCnt(inputMoney)
    val lottoList = lottoNumberLimit(count)
    lottoNumberPrint(count, lottoList)

    val lottoNumber = lottoNumberChoose()
    val bonusNumber = lottoNumberBonus()

    val result = lottoNumberCheck(lottoList, lottoNumber, bonusNumber)
    lottoResultPrint(result, count)



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
    if (lottoNumber.size != 6 || lottoNumber.toSet().size != 6) {
        throw IllegalArgumentException("중복되는 번호가 있습니다.")
    }
    return lottoNumber
}
fun lottoNumberBonus(): Int {
    println("보너스 번호를 입력해 주세요.")
    return readLine()!!.toInt()
}


fun lottoNumberCheck(lottoList: List<List<Int>>, comNumber: List<Int>, bonusNumber: Int): Map<Int, Int> {
    val lottoMoneyList = mutableMapOf(3 to 0, 4 to 0, 5 to 0, 6 to 0)
    var bonusNumberCnt = 0
    for (lotto in lottoList) {
        val sameNumber = lotto.filter { it in comNumber }.size
        when (sameNumber) {
            3 -> lottoMoneyList[3] = lottoMoneyList.getValue(3) + 1
            4 -> lottoMoneyList[4] = lottoMoneyList.getValue(4) + 1
            5 -> {
                if (lotto.contains(bonusNumber)) {
                    bonusNumberCnt++
                } else {
                    lottoMoneyList[5] = lottoMoneyList.getValue(5) + 1
                }
            }
            6 -> lottoMoneyList[6] = lottoMoneyList.getValue(6) + 1
        }
    }
    lottoMoneyList[5] = bonusNumberCnt
    return lottoMoneyList
}

fun lottoResultPrint(result: Map<Int, Int>, lottoCount: Int) {
    println("당첨 통계")
    println("---")
    for ((key, value) in result) {
        println("${key}개 일치 - ${value}개")
    }
}

