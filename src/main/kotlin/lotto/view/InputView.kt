package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.DELIMITER
import lotto.util.Validator.isValidPurchaseAmount
import lotto.util.Validator.isValidWinningNums

class InputView {
    private fun getPurchaseAmount(): String = Console.readLine()

    fun getValidPurchaseAmount(): String {
        return try {
            val userInput = getPurchaseAmount()
            isValidPurchaseAmount(userInput)
            userInput
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidPurchaseAmount()
        }
    }

    fun getValidWinningNums(): List<Int> {
        return try {
            val userInput = Console.readLine()
            isValidWinningNums(userInput)
            userInput.split(DELIMITER).map { it.toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidWinningNums()
        }
    }
}