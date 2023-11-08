package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

private var lottoPurchaseAmount: Int = -1
private var lottoCount: Int = -1
private val lottoRandomNumber: MutableList<List<Int>> = mutableListOf()

fun main() {

    println("구입금액을 입력해 주세요.")
    inputLottoPurchaseAmount()
    checkLottoPurchaseAmount()

    calculatorLottoCount()
    printLottoCount()

    generatorLottoRandomNumber()
    printLottoRandomNumber()

    println("당첨 번호를 입력해 주세요.")
    val lotto = Lotto(inputLottoNumber())

    println("보너스 번호를 입력해 주세요.")
    lotto.inputBonusNumber(inputBonusNumber())
}

private fun inputLottoPurchaseAmount() {
    try {
        lottoPurchaseAmount = readLine().toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 받습니다.")
    }
}

private fun checkLottoPurchaseAmount() {
    if (lottoPurchaseAmount.rem(1000) != 0) {
        throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위만 입력 받습니다.")
    }
}

private fun calculatorLottoCount() {
    lottoCount = lottoPurchaseAmount / 1000
}

private fun printLottoCount() {
    println("${lottoCount}개를 구매했습니다.")
}

private fun generatorLottoRandomNumber() {
    repeat(lottoCount) {
        val randomNumbers = pickUniqueNumbersInRange(1, 45, 6)
        lottoRandomNumber.add(randomNumbers.sorted())
    }
}

private fun printLottoRandomNumber() {
    lottoRandomNumber.forEach { println(it) }
}

private fun inputLottoNumber(): List<Int> {
    val inputNumber = readLine()
    val stringList = inputNumber.split(",")
    return stringList.map { it.toInt() }
}

private fun inputBonusNumber(): Int {
    val inputNumber = readLine()
    return inputNumber.toInt()
}