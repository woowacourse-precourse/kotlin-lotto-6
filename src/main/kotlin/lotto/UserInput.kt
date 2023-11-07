package lotto

import camp.nextstep.edu.missionutils.Console

class UserInput() {
    private val userInputValidator = UserInputValidator()

    fun purchasedAmountInput(): String {
        while(true) {
            val userInput = Console.readLine()
            try {
                userInputValidator.checkNumber(userInput)
                userInputValidator.checkDivideBy1000(userInput)
                return userInput
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun winningPriceInput(): List<String> {
        while (true) {
            val userInput = Console.readLine()
            val numberList = userInput.split(",")
            try {
                userInputValidator.checkNumberListSize(numberList)
                userInputValidator.checkNumberInList(numberList)
                return numberList
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNumberInput(numberList: List<String>): String {
        while(true) {
            val userInput = Console.readLine()
            try {
                userInputValidator.checkNumber(userInput)
                userInputValidator.checkNumberInRange(userInput)
                userInputValidator.checkDuplicatedNumber(numberList, userInput)
                return userInput
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}