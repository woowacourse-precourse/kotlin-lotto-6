package ui

import camp.nextstep.edu.missionutils.Console
import model.PurchaseLottoInfo
import validation.ValidationManager

class InputManager(private val validationManager: ValidationManager = ValidationManager()) {
    fun lottoPurchaseAmount(errorMessage: () -> Unit): PurchaseLottoInfo {
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

    fun bonusNumber(jackpotNumbers: List<Int>, errorMessage: () -> Unit): Int {
        return try {
            validationManager.validBonusNumber(bonusNumber = Console.readLine().toInt(), jackpotNumbers = jackpotNumbers)
        } catch (exception: IllegalArgumentException) {
            errorMessage()
            bonusNumber(errorMessage = errorMessage, jackpotNumbers = jackpotNumbers)
        }
    }
}