package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.isValidPurchaseAmount

class InputView {
    private fun getPurchaseAmount(): String = Console.readLine()

    fun getValidPurchaseAmount():String{
        return try {
            val userInput = getPurchaseAmount()
            isValidPurchaseAmount(userInput)
            userInput
        } catch (e:IllegalArgumentException){
            println(e.message)
            getValidPurchaseAmount()
        }
    }
}