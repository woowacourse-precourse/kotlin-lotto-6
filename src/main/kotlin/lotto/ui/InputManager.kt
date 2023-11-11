package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.validator.BonusNumberValidator
import lotto.validator.InputMoneyValidator
import lotto.validator.WinningNumbersValidator

class InputManager {
    private val outputManager = OutputManager()
    private val inputMoneyValidator = InputMoneyValidator()
    private val winningNumbersValidator = WinningNumbersValidator()
    private val bonusNumberValidator = BonusNumberValidator()

    fun getInputMoney(): Int {
        return getValidatedInput(INPUT_MONEY_PROMPT_MESSAGE, inputMoneyValidator::validate).toInt()
    }

    fun getWinningNumbers(): List<Int> {
        val winningNumbers = getValidatedInput(WINNING_NUMBERS_PROMPT_MESSAGE, winningNumbersValidator::validate)
        return winningNumbers.split(",").map { it.trim().toInt() }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        return getValidatedInput(BONUS_NUMBER_PROMPT_MESSAGE) {
            bonusNumberValidator.validate(it, winningNumbers)
        }.toInt()
    }

    private fun getValidatedInput(promptMessage: String, validate: (String) -> Unit): String {
        return try {
            outputManager.printPromptMessage(promptMessage)
            val input = readString()
            validate(input)
            input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidatedInput(promptMessage, validate)
        }
    }

    private fun readString(): String {
        return Console.readLine().trim()
    }

    companion object {
        private const val INPUT_MONEY_PROMPT_MESSAGE = "구입금액을 입력해 주세요."
        private const val WINNING_NUMBERS_PROMPT_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val BONUS_NUMBER_PROMPT_MESSAGE = "\n" + "보너스 번호를 입력해 주세요."
    }
}