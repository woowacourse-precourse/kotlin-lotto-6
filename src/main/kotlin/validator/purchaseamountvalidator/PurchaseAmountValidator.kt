package validator.purchaseamountvalidator

import view.OutputView

object PurchaseAmountValidator {
    private const val PURCHASE_AMOUNT_ERROR_MESSAGE = "로또 구입 금액은 1,000 단위여야 합니다."
    private const val PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE = "로또 구입 금액은 수여야 합니다."
    private const val LOTTO_AMOUNT_UNIT = 1000

    fun isAppropriatePurchaseAmount(purchaseAmount: String): Boolean {
        val result = purchaseAmount.toIntOrNull()
        requireNotNull(result) { OutputView.error(PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE) }
        require(result % LOTTO_AMOUNT_UNIT == 0 && result >= LOTTO_AMOUNT_UNIT) {
            OutputView.error(PURCHASE_AMOUNT_ERROR_MESSAGE)
        }
        return true
    }
}