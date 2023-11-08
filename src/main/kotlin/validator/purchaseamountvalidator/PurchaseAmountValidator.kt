package validator.purchaseamountvalidator

import view.OutputView

object PurchaseAmountValidator {
    private const val PURCHASE_AMOUNT_ERROR_MESSAGE = "로또 구입 금액은 1,000 단위여야 합니다."

    fun isAppropriatePurchaseAmount(purchaseAmount: Int): Boolean {
        require(purchaseAmount % 1000 == 0) { OutputView.error(PURCHASE_AMOUNT_ERROR_MESSAGE) }
        return true
    }
}