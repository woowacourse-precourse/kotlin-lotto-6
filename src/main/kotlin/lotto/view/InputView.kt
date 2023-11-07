package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.ExceptionMessages.ERROR
import lotto.constants.ExceptionMessages.EXCEPTION_UNEXPECTED
import lotto.constants.Constants.INPUT_BONUS_NUMBER
import lotto.constants.Constants.INPUT_PURCHASE_AMOUNT
import lotto.constants.Constants.INPUT_WINNING_NUMBERS
import lotto.constants.Constants.WINNING_NUM_SEPARATOR
import lotto.utils.InputViewValidation

class InputView {

    fun inputPurchaseAmount(): Int {
        return getUserAmount()
    }

    fun inputWinningNumberList(): List<Int> {
        return getWinningNumbers()
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        return getBonusNumber(winningNumbers)
    }

    private fun getUserAmount(): Int = try {
        val stepMessage = getStepMessage(INPUT_PURCHASE_AMOUNT)
        println(stepMessage)
        val userInput = Console.readLine()
        InputViewValidation.validateUserAmount(userInput)
        println()

        userInput.toInt()
    } catch (e: IllegalArgumentException) {
        e.message?.let {
            println(getErrorMessage(it))
        } ?: println()

        getUserAmount()
    }

    private fun getWinningNumbers(): List<Int> = try {
        val stepMessage = getStepMessage(INPUT_WINNING_NUMBERS)
        println(stepMessage)
        val numbers = Console.readLine()
        println()

        getWinningNumbersList(numbers)
    } catch (e: IllegalArgumentException) {
        println(getErrorMessage(e.message))

        getWinningNumbers()
    }

    private fun getWinningNumbersList(winningNumbers: String): List<Int> {
        val winningNumbersList = winningNumbers.split(WINNING_NUM_SEPARATOR)

        return InputViewValidation.getValidatedNumbersList(winningNumbersList)
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int = try {
        val stepMessage = getStepMessage(INPUT_BONUS_NUMBER)
        println(stepMessage)
        val bonus = Console.readLine()
        println()
        val bonusNum = InputViewValidation.getValidatedBonusNumber(bonus, winningNumbers)

        bonusNum
    } catch (e: IllegalArgumentException) {
        println(getErrorMessage(e.message))

        getBonusNumber(winningNumbers)
    }

    private fun getStepMessage(message: String): String = message

    private fun getErrorMessage(message: String? = EXCEPTION_UNEXPECTED) = "$ERROR $message"
}