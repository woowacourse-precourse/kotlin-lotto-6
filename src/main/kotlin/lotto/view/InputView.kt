package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator

class InputView {
    fun getValidateUserInput(): Int {
        val userInput = getUserInput()
        Validator.validateInteger(userInput)
        Validator.validateRange(userInput)
        Validator.validate1000Unit(userInput)
        return userInput.toInt()
    }

    private fun getUserInput(): String = Console.readLine()
}