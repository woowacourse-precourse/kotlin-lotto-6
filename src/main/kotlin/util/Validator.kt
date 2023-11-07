package util

object Validator {
    fun validatePurchaseAmount(purchaseAmount: String): Int {
        val validPurchaseAmount = purchaseAmount.toIntOrNull()
        requireNotNull(validPurchaseAmount) { ErrorMessage.INVALID_INPUT.message }
        require(validPurchaseAmount >= 1000) { ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.message }
        require(validPurchaseAmount % 1000 == 0) { ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.message }
        return validPurchaseAmount
    }

    fun validateWinningNumbers(winningNumbers: String): List<Int> {
        val validWinningNumbers = winningNumbers.split(",").map { winningNumber ->
            val validWinningNumber = winningNumber.toIntOrNull()
            requireNotNull(validWinningNumber) { ErrorMessage.INVALID_INPUT.message }
            validWinningNumber
        }
        require(validWinningNumbers.all { winningNumber -> winningNumber in 1..45 }) { ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.message }
        require(validWinningNumbers.size == 6) { ErrorMessage.INVALID_LOTTO_COUNT.message }
        require(validWinningNumbers.toSet().size == 6) { ErrorMessage.DUPLICATED_LOTTO_NUMBER.message }
        return validWinningNumbers
    }

    fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>): Int {
        val validBonusNumber = bonusNumber.toIntOrNull()
        requireNotNull(validBonusNumber) { ErrorMessage.INVALID_INPUT.message }
        require(validBonusNumber in 1..45) { ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.message }
        require(validBonusNumber !in winningNumbers) { ErrorMessage.DUPLICATED_BONUS_NUMBER.message }
        return validBonusNumber
    }
}