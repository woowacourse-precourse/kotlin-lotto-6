package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.validation.CheckInputValidation
import lotto.validation.ExceptionMessageManager


// 사용자 입력 관리
class InputManager (
    messenger: MessageManager
){
    private val checkInputValidation = CheckInputValidation()
    private val exceptionManager = ExceptionMessageManager()

    fun inputLottoWinningNumber(): Set<Int>? {
        try {
            val userInput = getUserInput()
            checkInputValidation.apply {
                checkIsBlank(userInput)
                val lotto = splitUserInput(userInput)
                checkLottoCount(lotto)

                val numbers = lotto.map{number ->
                    checkIsNumber(number)
                    checkIsLottoNumber(number)
                    number.toInt()
                }
                checkDuplication(numbers)

                return numbers.toSet()
            }
        } catch (e : IllegalArgumentException){
            exceptionManager.printErrorMessage(e.message)
        }
        return null
    }

    fun inputBonusNumber(lottoNumber: Set<Int>): Int? {
        try {
            val userInput = getUserInput()
            checkInputValidation.apply {
                checkIsBlank(userInput)
                checkIsNumber(userInput)
                val bonusNumber = userInput.toInt()
                checkBonusNumberDuplication(lottoNumber,bonusNumber)

                return bonusNumber
            }
        } catch (e: IllegalArgumentException) {
            exceptionManager.printErrorMessage(e.message)
        }
        return null
    }

    private fun getUserInput(): String = Console.readLine()

    private fun splitUserInput(userInput: String): List<String> =
        userInput.split(SPLIT_SEPARATOR)

    companion object {
        private const val SPLIT_SEPARATOR = ","
    }
}