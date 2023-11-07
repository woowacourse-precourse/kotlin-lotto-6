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
            val lotto = splitUserInput(userInput)
            checkInputValidation.checkLottoCount(lotto)
            val numbers = makeLottoNumbers(lotto)
            return numbers.toSet()
        } catch (e : IllegalArgumentException){
            exceptionManager.printErrorMessage(e.message)
        }
        return null
    }

    fun inputBonusNumber(lottoNumber: Set<Int>): Int? {
        try {
            val userInput = getUserInput()
            val bonusNumber = makeBonusNumber(userInput)
            checkInputValidation
                .checkBonusNumberDuplication(lottoNumber, bonusNumber)
            return bonusNumber
        } catch (e: IllegalArgumentException) {
            exceptionManager.printErrorMessage(e.message)
        }
        return null
    }

    private fun getUserInput(): String {
        val userInput = Console.readLine()
        checkInputValidation.checkIsBlank(userInput)
        return userInput
    }

    private fun splitUserInput(userInput: String): List<String> =
        userInput.split(SPLIT_SEPARATOR)

    private fun makeLottoNumbers(
        lotto: List<String>
    ): List<Int> {
        checkInputValidation.apply {
            val numbers = lotto.map { number ->
                checkIsNumber(number)
                checkIsLottoNumber(number)
                number.toInt()
            }
            checkDuplication(numbers)
            return numbers
        }
    }

    private fun makeBonusNumber(userInput: String): Int {
        checkInputValidation.checkIsNumber(userInput)
        return userInput.toInt()
    }

    companion object {
        private const val SPLIT_SEPARATOR = ","
    }
}