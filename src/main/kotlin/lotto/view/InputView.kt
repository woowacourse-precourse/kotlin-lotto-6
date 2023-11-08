package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.*
import lotto.exception.ContainsNotDigitException
import lotto.exception.UnvalidCostException
import lotto.utility.Utils

import kotlin.NumberFormatException

class InputView {
    val inputValidator = InputValidator()
    fun inputCost(): Int {
        while (true) {
            println(INPUT_MESSAGE_COST)
            val userInput = Console.readLine()

            try {
                inputValidator.checkStringHasNonDigits(userInput)
                inputValidator.checkCostDevidedByUnit(userInput)
                return userInput.toInt()
            } catch(error: ContainsNotDigitException) {
                println(error.message)
            } catch(error: UnvalidCostException) {
                println(error.message)
            }
        }
    }

    fun inputLottoNumbers(): String {
        while (true) {
            println(INPUT_MESSAGE_LOTTO_NUMBERS)
            val userInput = Console.readLine()


        }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_MESSAGE_BONUS_NUMBER)
        return readLine()!!.toInt()
    }

    fun checkInputString(input: String): Boolean {
        if (Utils.containsNonDigits(input)) {
            throw NumberFormatException(EXCEPTION_CONTAINS_NOT_DIGIT)
        }
        return true
    }
}