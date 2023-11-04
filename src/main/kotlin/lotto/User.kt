package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    private var _amount: Int = 0
    val amount get() = _amount

    private var _winningNumbers: MutableList<Int> = mutableListOf()
    val winningNumbers: List<Int> get() = _winningNumbers

    fun inputAmount() {
        val input = Console.readLine()
        setAmountFromInput(input.trim())
    }

    private fun setAmountFromInput(input: String) {
        require(isValidAmount(input)) { INVALID_AMOUNT_ERROR_MESSAGE }
        _amount = input.toInt()
    }

    fun inputWinningNumbers() {
        val input = Console.readLine()
        setWinningNumbers(input.split(SEPARATOR))
    }

    private fun setWinningNumbers(inputs: List<String>) {
        val trimmedInputs = inputs.map { it.trim() }
        trimmedInputs.forEach {
            require(isValidWinningNumber(it)) { INVALID_WINNING_NUMBER_ERROR_MESSAGE }
        }

        val numbers = trimmedInputs.map { it.toInt() }
        require(isValidNumberCount(numbers)) { INVALID_NUMBER_COUNT_ERROR_MESSAGE }
    }

    private fun isValidAmount(input: String) =
        isNotEmpty(input) && isInputDigitsOnly(input) && isAmountInUnit(input.toInt())

    private fun isNotEmpty(input: String) = input.isNotEmpty()

    private fun isInputDigitsOnly(input: String) = input.all { it.isDigit() }

    private fun isAmountInUnit(amount: Int) = amount >= AMOUNT_UNIT && amount % AMOUNT_UNIT == 0

    private fun isValidWinningNumber(input: String) = isNotEmpty(input) && isInputDigitsOnly(input)

    private fun isValidNumberCount(numbers: List<Int>) = numbers.size == NUMBER_COUNT

    companion object {
        const val AMOUNT_UNIT = 1000
        const val INVALID_AMOUNT_ERROR_MESSAGE = "금액은 $AMOUNT_UNIT 단위의 숫자만 입력이 가능합니다."

        const val SEPARATOR = ","
        const val INVALID_WINNING_NUMBER_ERROR_MESSAGE = "당첨 번호는 숫자로 입력해야 합니다."

        const val NUMBER_COUNT = 6
        const val INVALID_NUMBER_COUNT_ERROR_MESSAGE = "당첨 번호의 개수는 ${NUMBER_COUNT}개이어야 합니다."
    }
}