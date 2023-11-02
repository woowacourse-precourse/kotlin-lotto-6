package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constant.ExtraText
import lotto.util.UserInputValidator

class ReadUserInputView {
    private val validator = UserInputValidator()

    fun readUserSingleNumberInput(): Int {
        val userInput = Console.readLine()
        validateUserPurchaseAmountInput(userInput)
        return userInput.toInt()
    }

    fun readUserWinningNumberInput() {
        val userInput = Console.readLine()
        val splitUserInput = userInput.split(ExtraText.NUMBER_SEPARATOR.text)
        validateUserWinningNumberInput(splitUserInput)
    }

    private fun validateUserPurchaseAmountInput(userInput: String) {
        validator.isNumberFormat(userInput)
    }

    private fun validateUserWinningNumberInput(userInput: List<String>) {
        validator.isNumberListFormat(userInput)
    }
}