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

    fun validateWinningNumbers(winningNumbers: String): List<Int> {
        try {
            val validWinningNumbers = winningNumbers.split(",").map { winningNumber ->
                val validWinningNumber = winningNumber.toInt()
                require(validWinningNumber in 1..45) { ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.message }
                validWinningNumber
            }
            require(validWinningNumbers.size == 6) { ErrorMessage.INVALID_LOTTO_COUNT.message }
            require(validWinningNumbers.size == validWinningNumbers.toSet().size) { ErrorMessage.DUPLICATED_LOTTO_NUMBER.message }
            return validWinningNumbers
        } catch (numberFormatException: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.INVALID_INPUT.message)
        }
    }
}