package lotto.view

import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_DUPLICATED
import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_RANGE
import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_SIZE
import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_TYPE
import camp.nextstep.edu.missionutils.Console
import constants.ExceptionMessages.EXCEPTION_PURCHASE_DIVISION
import constants.ExceptionMessages.EXCEPTION_PURCHASE_NO_MORE_THAN_ZERO
import constants.ExceptionMessages.EXCEPTION_PURCHASE_STRING
import constants.ExceptionMessages.EXCEPTION_UNEXPECTED
import lotto.constants.Constants.INPUT_PURCHASE_AMOUNT
import lotto.constants.Constants.INPUT_WINNING_NUMBERS

object InputView {

    fun inputPurchaseAmount(): Int {
        printStepMessage(INPUT_PURCHASE_AMOUNT)
        return getUserAmount()
    }

    fun inputWinningNumberList(): List<Int> {
        printStepMessage(INPUT_WINNING_NUMBERS)
        return getWinningNumbers()
    }

    private fun getUserAmount(): Int = try {
        val userInput = Console.readLine()
        validateUserAmount(userInput)

        printStepMessage()

        userInput.toInt()
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message ?: EXCEPTION_UNEXPECTED)
        getUserAmount()
    }

    fun validateUserAmount(userInput: String) {
        try {
            val amount = userInput.toInt()

            if (amount <= 0) throw IllegalArgumentException(EXCEPTION_PURCHASE_NO_MORE_THAN_ZERO)
            if (amount % 1000 != 0) throw IllegalArgumentException(EXCEPTION_PURCHASE_DIVISION)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(EXCEPTION_PURCHASE_STRING)
        }
    }

    fun getWinningNumbers(): List<Int> = try {
        val numbers = Console.readLine()
        printStepMessage()
        getWinningNumbersList(numbers)
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message ?: EXCEPTION_UNEXPECTED)
        getWinningNumbers()
    }

    fun getWinningNumbersList(winningNumbers: String): List<Int> {
        val winningNumbersList = winningNumbers.split(",")

        return getValidatedNumbersList(winningNumbersList)
    }

    private fun getValidatedNumbersList(winningNumbers: List<String>): List<Int> = try {
        val winningNumbersList = winningNumbers.map {
            it.toInt()
        }
        validateWinningNumbersList(winningNumbersList)

        winningNumbersList
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(EXCEPTION_WINNING_NUMBERS_TYPE)
    }


    private fun validateWinningNumbersList(winningNumbers: List<Int>) {
        if (winningNumbers.size != 6) throw IllegalArgumentException(EXCEPTION_WINNING_NUMBERS_SIZE)
        if (winningNumbers.size != winningNumbers.distinct().count()) {
            throw IllegalArgumentException(EXCEPTION_WINNING_NUMBERS_DUPLICATED)
        }
        winningNumbers.onEach {
            if (it !in 1..45) throw IllegalArgumentException(EXCEPTION_WINNING_NUMBERS_RANGE)
        }
    }

    private fun printStepMessage(message: String? = null) {
        message?.let {
            println(message)
        } ?: println()
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }
}


