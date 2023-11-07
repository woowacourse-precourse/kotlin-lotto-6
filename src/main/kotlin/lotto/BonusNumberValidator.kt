package lotto

class BonusNumberValidator(private val input: String) {

    private val errorHandler = ErrorHandler()

    fun isValid(winningNumbers:List<Int>) = errorHandler.checkWithExceptionHandler(this::validateIsNumber, ErrorMessage.INVALID_BONUS_NUMBER.message, ErrorType.NumberFormatException) &&
            errorHandler.checkWithExceptionHandler({validateIsBallSameWithWinningNumbers(winningNumbers)}, ErrorMessage.SAME_WITH_WINNING_NUMBER.message, ErrorType.IllegalArgumentException) &&
            errorHandler.checkWithExceptionHandler(this::validateBonusRange, ErrorMessage.NUMBER_RANGE.message, ErrorType.IllegalArgumentException)

    private fun validateIsNumber(): Boolean = input.toIntOrNull() is Int

    private fun validateIsBallSameWithWinningNumbers(winningNumbers: List<Int>):Boolean {
        val bonusBall = input.toInt()
        return !winningNumbers.contains(bonusBall)
    }

    private fun validateBonusRange(): Boolean = input.toInt() in LottoNumber.MIN_LOTTO_NUMBER.number..LottoNumber.MAX_LOTTO_NUMBER.number
}