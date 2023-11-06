package lotto

import lotto.domain.LottoPurchase

fun main() {
    startLotto()
}

fun startLotto() {
    val purchaseLotto = LottoPurchase()
    val lotteryNumber = purchaseLotto.inputAmount()
}
