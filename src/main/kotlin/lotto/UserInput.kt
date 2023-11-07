package lotto

import camp.nextstep.edu.missionutils.Console

class UserInput() {
    private val userInputValidator = UserInputValidator()

    fun purchasedAmountInput() {
        while(true) {
            val userInput = Console.readLine()
            try {
                userInputValidator.checkNumber(userInput)
                userInputValidator.checkDivideBy1000(userInput)
                break
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}