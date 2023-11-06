package lotto.view

import camp.nextstep.edu.missionutils.Console
import constants.ExceptionMessages.EXCEPTION_UNEXPECTED
import lotto.constants.Constants.INPUT_PURCHASE_AMOUNT

object InputView {

    fun inputUserAmount(): Int {
        printStepMessage(INPUT_PURCHASE_AMOUNT)
        return getUserAmount()
    }

    private fun getUserAmount(): Int = try {
        val amount = Console.readLine().toInt()

        amount
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message ?: EXCEPTION_UNEXPECTED)
        getUserAmount()
    }

    private fun printStepMessage(message: String) {
        println(message)
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }
}