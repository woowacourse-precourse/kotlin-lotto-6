package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.*
import lotto.exception.*
import lotto.utility.Utils

import kotlin.NumberFormatException

class InputView {
    private val inputValidator = InputValidator()
    fun inputCost(): Int {
        while (true) {
            println(INPUT_MESSAGE_COST)
            val userInput = Console.readLine()

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
            println(INPUT_MESSAGE_LOTTO_NUMBERS)
            val userInput = Console.readLine()

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
            println(INPUT_MESSAGE_BONUS_NUMBER)
            val userInput = Console.readLine()

            try {
                inputValidator.checkBonusInput(userInput, lottoList)
            } catch (error: UnvalidLottoNumberException) {
                println(error.message)
            } catch (error: ContainsNotDigitException) {
                println(error.message)
            } catch (error: DuplicatedNumberException) {
                println(error.message)
            }
        }
    }
}