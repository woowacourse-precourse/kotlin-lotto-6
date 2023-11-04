package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    private var _amount: Int = 0
    val amount get() = _amount

    fun inputAmount() {
        val trimmedInput = readAndTrimInput()
        setAmountFromInput(trimmedInput)
    }

    private fun readAndTrimInput() = Console.readLine().trim()

    private fun setAmountFromInput(input: String) {
        require(isValidAmount(input)) { INVALID_DIGIT_AMOUNT }
        _amount = input.toInt()
    }

    private fun isValidAmount(input: String) = isNotEmpty(input) && isInputDigitsOnly(input)

    private fun isNotEmpty(input: String) = input.isNotEmpty()

    private fun isInputDigitsOnly(input: String) =  input.all { it.isDigit() }

    companion object {
        private const val INVALID_DIGIT_AMOUNT = "[ERROR] 금액은 숫자만 입력이 가능합니다."
    }
}