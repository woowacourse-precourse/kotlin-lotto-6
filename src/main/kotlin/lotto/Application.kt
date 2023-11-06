package lotto

import lotto.domain.PurchaseLotto

fun main() {
    startLotto()
}

fun startLotto() {
    val purchaseLotto = PurchaseLotto()
    val amount = purchaseLotto.inputAmount()
}
