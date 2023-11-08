package lotto.views

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputPurchaseAmount(): Int {
        val input = Console.readLine() ?: throw IllegalArgumentException(EMPTY_OR_BLANK_INPUT_ERROR_MESSAGE)

        return input.toInt()
    }

    companion object {
        const val EMPTY_OR_BLANK_INPUT_ERROR_MESSAGE = "다시 입력해주세요."

    }
}