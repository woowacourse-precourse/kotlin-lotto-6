package lotto.view

import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_DUPLICATED
import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_RANGE
import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_SIZE
import constants.ExceptionMessages.EXCEPTION_WINNING_NUMBERS_TYPE
import camp.nextstep.edu.missionutils.Console
import constants.ExceptionMessages.ERROR
import constants.ExceptionMessages.EXCEPTION_BONUS_NUMBER_DUPLICATED
import constants.ExceptionMessages.EXCEPTION_BONUS_NUMBER_RANGE
import constants.ExceptionMessages.EXCEPTION_BONUS_NUMBER_TYPE
import constants.ExceptionMessages.EXCEPTION_PURCHASE_DIVISION
import constants.ExceptionMessages.EXCEPTION_PURCHASE_NO_MORE_THAN_ZERO
import constants.ExceptionMessages.EXCEPTION_PURCHASE_STRING
import constants.ExceptionMessages.EXCEPTION_UNEXPECTED
import lotto.constants.Constants.INPUT_BONUS_NUMBER
import lotto.constants.Constants.INPUT_PURCHASE_AMOUNT
import lotto.constants.Constants.INPUT_WINNING_NUMBERS
import lotto.constants.Constants.LOTTO_SIZE

object InputView {

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
        printStepMessage(INPUT_PURCHASE_AMOUNT)
        val userInput = Console.readLine()
        validateUserAmount(userInput)

        printStepMessage()

        userInput.toInt()
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
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
        printStepMessage(INPUT_WINNING_NUMBERS)
        val numbers = Console.readLine()
        printStepMessage()
        getWinningNumbersList(numbers)
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
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
        if (winningNumbers.size != LOTTO_SIZE) throw IllegalArgumentException(EXCEPTION_WINNING_NUMBERS_SIZE)
        if (winningNumbers.size != winningNumbers.distinct().count()) {
            throw IllegalArgumentException(EXCEPTION_WINNING_NUMBERS_DUPLICATED)
        }
        winningNumbers.onEach {
            if (it !in 1..45) throw IllegalArgumentException(EXCEPTION_WINNING_NUMBERS_RANGE)
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int = try {
        printStepMessage(INPUT_BONUS_NUMBER)
        val bonus = Console.readLine()
        printStepMessage()
        val bonusNum = getValidatedBonusNumber(bonus, winningNumbers)
        bonusNum
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
        getBonusNumber(winningNumbers)
    }

    fun getValidatedBonusNumber(bonus: String, winningNumbers: List<Int>): Int = try {
        val bonusNum = bonus.toInt()
        if (bonusNum !in 1..45) throw IllegalArgumentException(EXCEPTION_BONUS_NUMBER_RANGE)
        if (bonusNum in winningNumbers) throw IllegalArgumentException(EXCEPTION_BONUS_NUMBER_DUPLICATED)
        bonusNum
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(EXCEPTION_BONUS_NUMBER_TYPE)
    }


    private fun printStepMessage(message: String? = null) {
        message?.let {
            println(message)
        } ?: println()
    }

    private fun printErrorMessage(message: String? = EXCEPTION_UNEXPECTED) {
        println("$ERROR $message")
    }
}


