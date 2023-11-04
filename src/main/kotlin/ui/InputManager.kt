package ui

import camp.nextstep.edu.missionutils.Console
import validation.ValidationManager

class InputManager(private val validationManager: ValidationManager = ValidationManager()) {
    fun lottoPurchaseAmount(errorMessage: () -> Unit): Int {
        return try {
            validationManager.validAmount(Console.readLine().toInt())
        } catch (exception: IllegalArgumentException) {
            errorMessage()
            lottoPurchaseAmount(errorMessage)
        }
    }

    fun jackpotNumbers(errorMessage: () -> Unit): ArrayList<Int> {
        return try {
            validationManager.validJackpotNumbers(Console.readLine())
        } catch (exception: IllegalArgumentException) {
            errorMessage()
            jackpotNumbers(errorMessage)
        }
    }

    fun bonusNumber(lottoNumbers: List<Int>, errorMessage: () -> Unit): Int {
        return try {
            validationManager.validBonusNumber(bonusNumber = Console.readLine().toInt(), lottoNumbers = lottoNumbers)
        } catch (exception: IllegalArgumentException) {
            errorMessage()
            bonusNumber(errorMessage = errorMessage, lottoNumbers = lottoNumbers)
        }
    }
}