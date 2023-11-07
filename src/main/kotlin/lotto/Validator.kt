package lotto

class Validator(private val input: String) {
    fun isPaymentValid(): Boolean = ErrorHandler().checkWithExceptionHandler(this::validateIsNumber, INVALID_PAYMENT_NUMBER, ErrorType.NumberFormatException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsUpperToThousand, INVALID_MINIMUM_PAYMENT, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsCorrectUnit, DIVIDE_TO_THOUSAND, ErrorType.IllegalArgumentException)

    private fun validateIsNumber(): Boolean = input.toIntOrNull() is Int

    private fun validateIsUpperToThousand(): Boolean {
        val payment = input.toInt()
        return payment >= 1_000
    }

    private fun validateIsCorrectUnit(): Boolean {
        val payment = input.toInt()
        return payment % 1_000 == 0
    }

    fun isWinningNumbersValid(): Boolean =
            ErrorHandler().checkWithExceptionHandler(this::validateIsNotStartWithComma, COMMA_START_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsNotEndWithComma, COMMA_END_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateAreNumbers, INVALID_WINNING_NUMBER, ErrorType.NumberFormatException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsUnique, SAME_NUMBER_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateNumberCount, LOTTO_NUMBER_COUNT_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateNumbersRange, NUMBER_RANG_ERROR, ErrorType.IllegalArgumentException)

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
        return winningNumbers.size == LOTTO_NUMBER_COUNT
    }

    private fun validateNumbersRange(): Boolean {
        val winningNumbers = input.split(",").map { it.toInt() }
        return winningNumbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }
    }

    fun isBonusBallValid(winningNumbers:List<Int>) = ErrorHandler().checkWithExceptionHandler(this::validateIsNumber, INVALID_BONUS_NUMBER, ErrorType.NumberFormatException) &&
            ErrorHandler().checkWithExceptionHandler({validateIsBallSameWithWinningNumbers(winningNumbers)}, SAME_WITH_WINNING_NUMBER_ERROR, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateBonusRange, NUMBER_RANG_ERROR, ErrorType.IllegalArgumentException)

    private fun validateIsBallSameWithWinningNumbers(winningNumbers: List<Int>):Boolean {
        val bonusBall = input.toInt()
        return !winningNumbers.contains(bonusBall)
    }

    private fun validateBonusRange(): Boolean = input.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER

    companion object {
        const val INVALID_PAYMENT_NUMBER = "지불금액은 숫자로만 입력가능합니다."
        const val INVALID_MINIMUM_PAYMENT = "최소 지불 금액은 1000원입니다."
        const val DIVIDE_TO_THOUSAND = "지불 금액은 1000원 단위로 입력되어야 합니다."
        const val COMMA_START_ERROR = "처음에 콤마가 추가되었습니다. 콤마로 입력을 시작해서는 안됩니다."
        const val COMMA_END_ERROR = "콤마로 입력이 끝나서는 안됩니다."
        const val INVALID_WINNING_NUMBER = "당첨번호는 숫자로만 입력되어야합니다."
        const val SAME_NUMBER_ERROR = "중복된 숫자가 있으면 안됩니다."
        const val LOTTO_NUMBER_COUNT_ERROR = "6개의 숫자가 입력되어야 합니다."
        const val NUMBER_RANG_ERROR = "1과 45 사이의 숫자가 입력되어야 합니다."
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
        const val INVALID_BONUS_NUMBER = "보너스 볼은 숫자로만 입력되어야합니다."
        const val SAME_WITH_WINNING_NUMBER_ERROR = "당첨 번호와 중복되어서는 안됩니다."
    }
}