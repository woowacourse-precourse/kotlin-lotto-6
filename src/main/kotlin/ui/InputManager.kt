package ui

import camp.nextstep.edu.missionutils.Console
import validation.ValidationManager

class InputManager(private val validationManager: ValidationManager = ValidationManager()) {
    fun inputLottoPurchaseAmount(errorMessage: () -> Unit): Int {
        return try {
            validationManager.validateAmount(Console.readLine().toInt())
        } catch (exception: IllegalArgumentException) {
            errorMessage()
            inputLottoPurchaseAmount(errorMessage)
        }
    }

    fun inputJackpotNumbers(errorMessage: () -> Unit): List<Int> {
        return try {
            validationManager.validateJackpotNumbers(Console.readLine())
        } catch (exception: IllegalArgumentException) {
            errorMessage()
            inputJackpotNumbers(errorMessage)
        }
    }
}