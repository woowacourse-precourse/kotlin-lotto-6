package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun buyingAmountPrompt() =
        promptInput(BUYING_AMOUNT_INPUT_MESSAGE, BUYING_AMOUNT_IS_EMPTY)

    fun winningNumbersPrompt() =
        promptInput(WINNING_NUMBERS_INPUT_MESSAGE, WINNING_NUMBERS_IS_EMPTY)

    fun bonusNumberPrompt() =
        promptInput(BOUNS_NUMBER_INPUT_MESSAGE, BOUNS_NUMBER_IS_EMPTY)

    fun promptInput(messageForInput: String, errorMessage: String): String {
        println(messageForInput)

        val inputData = Console.readLine().also { println() }
        inputData.validateEmpty(errorMessage)

        return inputData
    }

    private fun String.validateEmpty(errorMessage: String) {
        if (this.isEmpty()) {
            throw IllegalArgumentException(errorMessage)
        }
    }

    companion object {
        private const val BUYING_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."
        const val BUYING_AMOUNT_IS_EMPTY = "구입금액이 입력되지 않았습니다."

        private const val WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
        const val WINNING_NUMBERS_IS_EMPTY = "당첨 번호가 입력되지 않았습니다."

        private const val BOUNS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."
        const val BOUNS_NUMBER_IS_EMPTY = "보너스 번호가 입력되지 않았습니다."
    }
}