package lotto

class Validator(private val input: String) {
    fun isPaymentValid(): Boolean = ErrorHandler().checkWithExceptionHandler(this::validateIsNumber, INVALID_PAYMENT_NUMBER, ErrorType.NumberFormatException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsUpperToThousand, INVALID_MINIMUM_PAYMENT, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsCorrectUnit, DIVIDE_TO_THOUSAND, ErrorType.IllegalArgumentException)

    private fun validateIsNumber(): Boolean = input.toIntOrNull() is Int

    private fun validateIsUpperToThousand(): Boolean {
        val payment = input.toInt()
        return payment >= 1000
    }

    private fun validateIsCorrectUnit(): Boolean {
        val payment = input.toInt()
        return payment % 1_000 == 0
    }

    fun isWinningNumbersValid(): Boolean =
            ErrorHandler().checkWithExceptionHandler(this::validateIsNotStartWithComma, WINNING_NUMBER_COMMA_START_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsNotEndWithComma, WINNING_NUMBER_COMMA_END_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateAreNumbers, WINNING_NUMBER_INVALID_NUMBER, ErrorType.NumberFormatException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateAreNumbers, WINNING_NUMBER_INVALID_NUMBER, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsUnique, WINNING_NUMBER_SAME_NAME_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateNumberCount, WINNING_NUMBER_COUNT_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateNumbersRange, WINNING_NUMBER_RANGE, ErrorType.IllegalArgumentException)

    private fun validateIsNotStartWithComma() :Boolean = !input.startsWith(",")

    private fun validateIsNotEndWithComma(): Boolean = !input.endsWith(",")

    private fun validateAreNumbers(): Boolean {
        val winningNumbers = input.trim().split(",")
        return winningNumbers.all { it.toIntOrNull() is Int }
    }

    private fun validateIsUnique(): Boolean {
        val winningNumbers = input.trim().split(",").map { it.toInt() }
        return winningNumbers.toSet().size == winningNumbers.size
    }

    private fun validateNumberCount(): Boolean {
        val winningNumbers = input.trim().split(",").map { it.toInt() }
        return winningNumbers.size == LOTTO_NUMBER_COUNT
    }

    private fun validateNumbersRange(): Boolean {
        val winningNumbers = input.trim().split(",").map { it.toInt() }
        return winningNumbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }
    }

    companion object {
        const val INVALID_PAYMENT_NUMBER = "지불금액은 숫자로만 입력가능합니다."
        const val INVALID_MINIMUM_PAYMENT = "최소 지불 금액은 1000원입니다."
        const val DIVIDE_TO_THOUSAND = "지불 금액은 1000원 단위로 입력되어야 합니다."
        const val WINNING_NUMBER_COMMA_START_ERROR = "처음에 콤마가 추가되었습니다. 콤마로 입력을 시작해서는 안됩니다."
        const val WINNING_NUMBER_COMMA_END_ERROR = "콤마로 입력이 끝나서는 안됩니다."
        const val WINNING_NUMBER_INVALID_NUMBER = "당첨번호는 숫자로만 입력되어야합니다."
        const val WINNING_NUMBER_SAME_NAME_ERROR = "중복된 숫자가 있으면 안됩니다."
        const val WINNING_NUMBER_COUNT_ERROR = "6개의 숫자가 입력되어야 합니다."
        const val WINNING_NUMBER_RANGE = "1과 45 사이의 숫자가 입력되어야 합니다."
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
    }
}