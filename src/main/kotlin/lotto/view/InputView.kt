package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.*
import lotto.exception.*
import lotto.utility.Utils

import kotlin.NumberFormatException

class InputView {
    private val inputValidator = InputValidator()
    private var userInput : String = ""
    fun inputCost(): Int {
        while (true) {
            printMessageAndGetInput(INPUT_MESSAGE_COST)

            try {
                inputValidator.checkCostInput(userInput)
                return userInput.toInt()
            } catch(error: ContainsNotDigitException) {
                println(error.message)
            } catch(error: UnvalidCostException) {
                println(error.message)
            } catch(error: NotPositiveCostException) {
                println(error.message)
            }
        }
    }

    fun inputLottoNumbers(): List<Int> {
        while (true) {
            printMessageAndGetInput(INPUT_MESSAGE_LOTTO_NUMBERS)

            try {
                inputValidator.checkLottoInput(userInput)
                return Utils.parseWithComma(userInput)
            } catch (error: UnvalidNubmerFormatException) {
                println(error.message)
            } catch (error: UnvalidLottoNumberCountException) {
                println(error.message)
            } catch (error: DuplicatedNumberException) {
                println(error.message)
            }
        }
    }

    fun inputBonusNumber(lottoList: List<Int>): Int {
        while (true) {
            printMessageAndGetInput(INPUT_MESSAGE_BONUS_NUMBER)

            try {
                inputValidator.checkBonusInput(userInput, lottoList)
                return userInput.toInt()
            } catch (error: UnvalidLottoNumberException) {
                println(error.message)
            } catch (error: ContainsNotDigitException) {
                println(error.message)
            } catch (error: DuplicatedNumberException) {
                println(error.message)
            }
        }
    }

    private fun printMessageAndGetInput(string: String) {
        println(string)
        userInput = Console.readLine()
    }
}