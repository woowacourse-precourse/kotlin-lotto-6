package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.validation.CheckInputValidation


// 사용자 입력 관리
class InputManager(
    private val printer : MessageManager
) {
    val checkInputValidation = CheckInputValidation()

//    fun inputLottoWinningNumber(): String {
//        while (true){
//            val userInput = getUserInput()
//            try {
//
//            } catch (e: IllegalArgumentException){
//                when(e.message){
//                    ErrorState.IS_NOT_POSITIVE_INTEGER.message -> {
//                        printer.printErrorMessage(ErrorState.IS_INCORRECT_NUMBER)
//                    }
//                    else -> {}
//                }
//            } catch (e: IllegalStateException){
//            }
//
//            return userInput
//        }
//    }
//
//    fun inputBonusNumber(): String {
//        val userInput = getUserInput()
//    }


    private fun getUserInput(): String = Console.readLine()

}