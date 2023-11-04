package util

object Validator {
    fun validatePurchaseAmount(purchaseAmount: String): Int {
        try {
            val validPurchaseAmount = purchaseAmount.toInt()
            require(validPurchaseAmount >= 1000) { ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.message }
            require(validPurchaseAmount % 1000 == 0) { ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.message }
            return validPurchaseAmount
        } catch (numberFormatException: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.INVALID_INPUT.message)
        }
    }
}