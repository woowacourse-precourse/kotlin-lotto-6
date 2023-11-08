package lotto.views

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputPurchaseAmount(): Int {
        val input = Console.readLine() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        require(isEmptyOrBlankInput(input)) { INPUT_ERROR_MESSAGE }

        return validatePurchaseAmountInput(input.trim())
    }

    internal fun validatePurchaseAmountInput(input: String): Int {
        require(isNotDigitInput(input.trim())) { NOT_DIGIT_INPUT_ERROR_MESSAGE }

        return input.toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        val input = Console.readLine() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        require(isEmptyOrBlankInput(input)) { INPUT_ERROR_MESSAGE }

        return validateWinningNumbersInput(input)
    }

    private fun validateWinningNumbersInput(input: String): List<Int> {
        val splitInputs = input.split(SEPARATOR)
        val trimmedInputs = splitInputs.map { it.trim() }
        trimmedInputs.forEach {
            require(isNotDigitInput(it)) { LOTTO_NUMBER_DIGIT_ERROR_MESSAGE }
        }

        return trimmedInputs.map { it.toInt() }
    }

    private fun isEmptyOrBlankInput(input: String) = input.isEmpty() or input.isBlank()

    private fun isNotDigitInput(input: String) = input.all { it.isDigit() }

    companion object {
        const val INPUT_ERROR_MESSAGE = "다시 입력해주세요."
        const val NOT_DIGIT_INPUT_ERROR_MESSAGE = "숫자로만 입력해주세요."

        const val SEPARATOR = ","
        const val LOTTO_NUMBER_DIGIT_ERROR_MESSAGE = "로또 번호는 숫자로만 입력해주세요."
    }
}