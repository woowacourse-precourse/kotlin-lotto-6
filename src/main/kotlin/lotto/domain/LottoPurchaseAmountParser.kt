package lotto.domain

import lotto.constants.ErrorConstants
import lotto.constants.GameConstants.PURCHASE_UNIT

object LottoPurchaseAmountParser {
    fun parse(lottoPurchaseAmount: String): Int {
        val amount = lottoPurchaseAmount.toIntOrNull()
            ?: throw IllegalArgumentException(ErrorConstants.INPUT_ERROR_MESSAGE)

        validateAmountRange(amount)
        validateAmountByUnit(amount)

        return amount / PURCHASE_UNIT
    }

    private fun validateAmountRange(amount: Int) {
        require(amount >= PURCHASE_UNIT) {
            ErrorConstants.UNAVAILABLE_PURCHASE_AMOUNT_ERROR_MESSAGE
        }
    }

    private fun validateAmountByUnit(amount: Int) {
        require(amount % PURCHASE_UNIT == 0) {
            ErrorConstants.UNAVAILABLE_PURCHASE_AMOUNT_BY_THOUSAND_ERROR_MESSAGE
        }
    }
}
