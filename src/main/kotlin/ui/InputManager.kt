package ui

import camp.nextstep.edu.missionutils.Console
import validation.ValidationManager

class InputManager(private val validationManager: ValidationManager = ValidationManager()) {
    fun inputLottoPurchaseAmount() {
        val lottoPurchaseAmount = validationManager.validateAmount(Console.readLine())
        println(lottoPurchaseAmount)
    }
}