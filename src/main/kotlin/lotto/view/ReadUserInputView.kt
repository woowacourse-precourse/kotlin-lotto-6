package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constant.ExtraText
import lotto.domain.BonusNumber
import lotto.domain.WinningNumbers
import lotto.util.UserInputValidator

class ReadUserInputView {
    private val validator = UserInputValidator()

    fun readUserPurchaseAmountInput(): Int {
        val userInput = Console.readLine()
        validateUserPurchaseAmountInput(userInput)
        return userInput.toInt()
    }

    fun readUserWinningNumberInput(): WinningNumbers {
        val userInput = Console.readLine()
        validator.isContainBlank(userInput)
        val splitUserInput = userInput.split(ExtraText.NUMBER_SEPARATOR.text)
        validateUserWinningNumberInput(splitUserInput)
        return WinningNumbers(splitUserInput.map { it.toInt() }.toList())
    }

    fun readUserBonusNumberInput(): BonusNumber {
        val userInput = Console.readLine()
        validateBonusNumberInput(userInput)
        return BonusNumber(userInput.toInt())
    }

    private fun validateUserPurchaseAmountInput(userInput: String) {
        validator.isPurchaseAmountFormat(userInput)
    }

    private fun validateBonusNumberInput(userInput: String) {
        validator.isBonusNumberFormat(userInput)
    }

    private fun validateUserWinningNumberInput(userInput: List<String>) {
        validator.isNumberListFormat(userInput)
    }
}