package lotto

class WinningNumbersValidator(private val input: String) {

    private val errorHandler = ErrorHandler()

    fun isValid(): Boolean =
        errorHandler.checkWithExceptionHandler(this::validateIsNotStartWithComma, ErrorMessage.COMMA_START.message, ErrorType.IllegalArgumentException) &&
                errorHandler.checkWithExceptionHandler(this::validateIsNotEndWithComma, ErrorMessage.COMMA_END.message, ErrorType.IllegalArgumentException) &&
                errorHandler.checkWithExceptionHandler(this::validateAreNumbers, ErrorMessage.INVALID_WINNING_NUMBER.message, ErrorType.NumberFormatException) &&
                errorHandler.checkWithExceptionHandler(this::validateIsUnique, ErrorMessage.SAME_NUMBER.message, ErrorType.IllegalArgumentException) &&
                errorHandler.checkWithExceptionHandler(this::validateNumberCount, ErrorMessage.LOTTO_NUMBER_COUNT.message, ErrorType.IllegalArgumentException) &&
                errorHandler.checkWithExceptionHandler(this::validateNumbersRange, ErrorMessage.NUMBER_RANGE.message, ErrorType.IllegalArgumentException)

    private fun validateIsNotStartWithComma() :Boolean = !input.startsWith(",")

    private fun validateIsNotEndWithComma(): Boolean = !input.endsWith(",")

    private fun validateAreNumbers(): Boolean {
        val winningNumbers = input.split(",")
        return winningNumbers.all { it.toIntOrNull() is Int }
    }

    private fun validateIsUnique(): Boolean {
        val winningNumbers = input.split(",").map { it.toInt() }
        return winningNumbers.toSet().size == winningNumbers.size
    }

    private fun validateNumberCount(): Boolean {
        val winningNumbers = input.split(",").map { it.toInt() }
        return winningNumbers.size == LottoNumber.LOTTO_NUMBER_COUNT.number
    }

    private fun validateNumbersRange(): Boolean {
        val winningNumbers = input.split(",").map { it.toInt() }
        return winningNumbers.all { it in LottoNumber.MIN_LOTTO_NUMBER.number..LottoNumber.MAX_LOTTO_NUMBER.number }
    }

}