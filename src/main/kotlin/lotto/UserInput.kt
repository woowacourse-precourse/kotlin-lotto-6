package lotto

import camp.nextstep.edu.missionutils.Console

class UserInput() {
    private val userInputValidator = UserInputValidator()

    fun purchasedAmountInput(): String {
        while(true) {
            println(LottoGameMessage.PURCHASE_AMOUNT_INPUT)
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
            println(LottoGameMessage.WINNING_NUMBER_INPUT)
            val userInput = Console.readLine()
            val numberList = userInput.split(",")
            try {
                userInputValidator.checkNumberListSize(numberList)
                userInputValidator.checkNumberInList(numberList)
                userInputValidator.checkDuplicatedNumberInList(numberList)
                return numberList
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNumberInput(numberList: List<String>): String {
        while(true) {
            println(LottoGameMessage.BONUS_NUMBER_INPUT)
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