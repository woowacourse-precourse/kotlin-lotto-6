package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getUserInput(): String {
        val input = Console.readLine()
        validateNotBlank(input)
        return input.trim()
    }

    fun terminated() = Console.close()

    private fun validateNotBlank(input: String) {
        require(input.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    companion object {
        private const val EMPTY_INPUT_ERROR = "값을 입력해주세요."
    }
}