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
        return try {
            outputManager.printPromptMessage(INPUT_MONEY_PROMPT_MESSAGE)
            val inputMoney = readString()
            inputMoneyValidator.validate(inputMoney)
            inputMoney.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getInputMoney()
        }
    }

    fun getWinningNumbers(): List<Int> {
        return try {
            outputManager.printPromptMessage(WINNING_NUMBERS_PROMPT_MESSAGE)
            val winningNumber = readString()
            winningNumbersValidator.validate(winningNumber)
            winningNumber.split(",").map { it.trim().toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumber: List<Int>): Int {
        return try {
            outputManager.printPromptMessage(BONUS_NUMBER_PROMPT_MESSAGE)
            val bonusNumber = readString()
            bonusNumberValidator.validate(bonusNumber, winningNumber)
            bonusNumber.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getBonusNumber(winningNumber)
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