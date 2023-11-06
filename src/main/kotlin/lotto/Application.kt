package lotto

import lotto.domain.LottoPurchase
import lotto.ui.Output

fun main() {
    startLotto()
}

fun startLotto() {
    val purchaseLotto = LottoPurchase()
    val lotteryNumber = purchaseLotto.inputAmount()
    Output.printLotteryNumber(lotteryNumber)
}
