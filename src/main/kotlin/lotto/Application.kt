package lotto

import camp.nextstep.edu.missionutils.Console.readLine

private var lottoPurchaseAmount: Int = -1
private var lottoCount: Int = -1

fun main() {

    println("구입금액을 입력해 주세요.")
    inputLottoPurchaseAmount()
    checkLottoPurchaseAmount()

    calculatorLottoCount()
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
