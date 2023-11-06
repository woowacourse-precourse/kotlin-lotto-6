package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.validation.CheckInputValidation


// 사용자 입력 관리
class InputManager {
    val checkInputValidation = CheckInputValidation()

    fun inputLottoWinningNumber(): Set<Int> {
        val userInput = getUserInput()
        return setOf() // 임시
    }

    fun inputBonusNumber(): Int {
        val userInput = getUserInput()
        return 0 // 임시
    }

    private fun checkLottoNumberValidation(
        userInput: String
    ){

    }

    private fun checkBonusNumberValidation(
        userInput: String,
        isValidation: (Boolean) -> Unit
    ){

    }

    private fun getUserInput(): String = Console.readLine()

    private fun splitUserInput(userInput: String): List<String> = userInput.split(SPLIT_SEPARATOR)

    companion object {
        private const val SPLIT_SEPARATOR = ","
    }
}