package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.*
import lotto.exception.*
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

    fun inputLottoNumbers(): List<Int> {
        while (true) {
            println(INPUT_MESSAGE_LOTTO_NUMBERS)
            val userInput = Console.readLine()

            try {
                inputValidator.checkLottoNumberCount(userInput)
                inputValidator.checkListNumberIsInRange(userInput)
                return Utils.parseWithComma(userInput)
            } catch (error: UnvalidNubmerFormatException) {
                println(error.message)
            } catch (error: UnvalidLottoNumberCountException) {
                println(error.message)
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            println(INPUT_MESSAGE_BONUS_NUMBER)
            val userInput = Console.readLine()

            try {
                inputValidator.checkListNumberIsInRange(userInput)
            } catch (error: UnvalidLottoNumberException) {
                println(error.message)
            }
        }
    }
}