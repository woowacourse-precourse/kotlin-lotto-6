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
        require(isValidAmount(input)) { INVALID_AMOUNT_ERROR_MESSAGE }
        _amount = input.toInt()
    }

    private fun isValidAmount(input: String) =
        isNotEmpty(input) && isInputDigitsOnly(input) && isAmountInUnit(input.toInt())

    private fun isNotEmpty(input: String) = input.isNotEmpty()

    private fun isInputDigitsOnly(input: String) = input.all { it.isDigit() }

    private fun isAmountInUnit(amount: Int) = amount >= AMOUNT_UNIT && amount % AMOUNT_UNIT == 0

    companion object {
        const val AMOUNT_UNIT = 1000
        const val INVALID_AMOUNT_ERROR_MESSAGE = "금액은 $AMOUNT_UNIT 단위의 숫자만 입력이 가능합니다."
    }
}