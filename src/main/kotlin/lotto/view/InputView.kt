package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants.DELIMITER
import lotto.util.Validator.isValidBonusNum
import lotto.util.Validator.isValidPurchaseAmount
import lotto.util.Validator.isValidWinningNums

class InputView {
    private fun getUserInput(): String = Console.readLine()

    private fun getInputValidation(validationFunction: (String) -> Unit): String {
        return try {
            val userInput = getUserInput()
            validationFunction(userInput)
            userInput
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getInputValidation(validationFunction)
        }
    }

    fun getValidPurchaseAmount(): String = getInputValidation(::isValidPurchaseAmount)

    fun getValidWinningNums(): List<Int> {
        var winningNums = listOf<Int>()
        getInputValidation {
            isValidWinningNums(it)
            winningNums = it.split(DELIMITER).map { num -> num.toInt() }
        }
        return winningNums
    }

    fun getValidBonusNum(winningNums: List<Int>): Int {
        var bonusNum = 0
        getInputValidation{
            isValidBonusNum(it,winningNums)
            bonusNum= it.toInt()
        }
        return bonusNum
    }
}