package lotto.view

import camp.nextstep.edu.missionutils.Console
import constants.ExceptionMessages.EXCEPTION_PURCHASE_DIVISION
import constants.ExceptionMessages.EXCEPTION_PURCHASE_NO_MORE_THAN_ZERO
import constants.ExceptionMessages.EXCEPTION_PURCHASE_STRING
import constants.ExceptionMessages.EXCEPTION_UNEXPECTED
import lotto.constants.Constants.INPUT_PURCHASE_AMOUNT

object InputView {

    fun inputPurchaseAmount(): Int {
        printStepMessage(INPUT_PURCHASE_AMOUNT)
        return getUserAmount()
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

    private fun printStepMessage(message: String? = null) {
        message?.let {
            println(message)
        } ?: println()
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }
}