package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.DELIMITER
import lotto.util.Validator.isValidPurchaseAmount
import lotto.util.Validator.isValidWinningNums

class InputView {
    private fun getUserInput(): String = Console.readLine()

    fun getValidPurchaseAmount(): String {
        return try {
            val userInput = getUserInput()
            isValidPurchaseAmount(userInput)
            userInput
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidPurchaseAmount()
        }
    }

    fun getValidWinningNums(): List<Int> {
        return try {
            val userInput = getUserInput()
            isValidWinningNums(userInput)
            userInput.split(DELIMITER).map { it.toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidWinningNums()
        }
    }
}