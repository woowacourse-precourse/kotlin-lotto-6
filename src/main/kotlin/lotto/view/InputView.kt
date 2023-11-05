package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants.DELIMITER
import lotto.util.Validator.isValidBonusNum
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

    fun getValidBonusNum(winningNums:List<Int>):Int{
        return try {
            val userInput = getUserInput()
            isValidBonusNum(userInput,winningNums)
            userInput.toInt()
        }catch (e:IllegalArgumentException){
            println(e.message)
            getValidBonusNum(winningNums)
        }
    }
}