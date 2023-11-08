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
            outputManager.printInputMoneyPrompt()
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
            outputManager.printWinningNumbersPrompt()
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
            outputManager.printBonusNumberPrompt()
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
}