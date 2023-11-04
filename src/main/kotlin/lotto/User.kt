package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    private var _amount: Int = 0
    val amount get() = _amount

    fun inputAmount() {
        val input = Console.readLine()
        val trimInput = input.trim()

        require(isValidDigit(trimInput)) { INVALID_DIGIT_AMOUNT }

        _amount = trimInput.toInt()
    }

    private fun isValidDigit(input: String) = input.all { it.isDigit() }

    companion object {
        private const val INVALID_DIGIT_AMOUNT = "[ERROR] 금액은 숫자만 입력이 가능합니다."
    }
}