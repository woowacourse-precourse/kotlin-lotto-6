package lotto.views

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputPurchaseAmount(): Int {
        printPromptMessage(INPUT_PURCHASE_AMOUNT_MESSAGE)
        val input = Console.readLine() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)

        require(isNotEmptyOrBlankInput(input)) { INPUT_ERROR_MESSAGE }

        return validatePurchaseAmountInput(input)
    }

    internal fun validatePurchaseAmountInput(input: String): Int {
        val trimmedInput = input.trim()

        require(isNotDigitInput(trimmedInput)) { NOT_DIGIT_INPUT_ERROR_MESSAGE }

        return input.toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        printPromptMessage(INPUT_WINNING_NUMBERS_MESSAGE)
        val input = Console.readLine() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)

        require(isNotEmptyOrBlankInput(input)) { INPUT_ERROR_MESSAGE }

        return validateWinningNumbersInput(input)
    }

    internal fun validateWinningNumbersInput(input: String): List<Int> {
        val splitInputs = input.split(SEPARATOR)
        val trimmedInputs = splitInputs.map { it.trim() }

        trimmedInputs.forEach {
            require(isNotDigitInput(it)) { LOTTO_NUMBER_DIGIT_ERROR_MESSAGE }
        }

        return trimmedInputs.map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        printPromptMessage(INPUT_BONUS_NUMBER_MESSAGE)
        val input = Console.readLine() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)

        require(isNotEmptyOrBlankInput(input)) { INPUT_ERROR_MESSAGE }

        return validateBonusNumber(input)
    }

    internal fun validateBonusNumber(input: String): Int {
        val trimmedInput = input.trim()

        require(isNotDigitInput(trimmedInput)) { BONUS_NUMBER_DIGIT_ERROR_MESSAGE }

        return input.toInt()
    }

    fun endInput() = println()

    fun closeInput() = Console.close()

    private fun printPromptMessage(message: String) = println(message)

    private fun isNotEmptyOrBlankInput(input: String) = !(input.isEmpty() || input.isBlank())

    private fun isNotDigitInput(input: String) = input.all { it.isDigit() }

    companion object {
        const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

        const val INPUT_ERROR_MESSAGE = "다시 입력해주세요."
        const val NOT_DIGIT_INPUT_ERROR_MESSAGE = "숫자로만 입력해주세요."

        const val SEPARATOR = ","
        const val LOTTO_NUMBER_DIGIT_ERROR_MESSAGE = "로또 번호는 숫자로만 입력해주세요."

        const val BONUS_NUMBER_DIGIT_ERROR_MESSAGE = "보너스 번호는 숫자로만 입력해주세요."
    }
}