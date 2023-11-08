package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants
import lotto.util.Constants.INPUT_MONEY
import lotto.util.Validation

class Input {

    fun inputPurchaseAmount(): Int {
        println(INPUT_MONEY)
        return try {
            val amount = Console.readLine()
            Validation.validatePurchaseAmount(amount)
            println()
            amount.toInt()
        } catch (e: IllegalArgumentException) {
            println(e)
            inputPurchaseAmount()
        }
    }

    fun inputWinningNumbers(): List<Int> {
        println("\n" + Constants.INPUT_WINNING_NUMBERS)
        return try {
            val winningNumbers = Console.readLine().split(",")
            Validation.validateWinningNumbers(winningNumbers)
            winningNumbers.map { it.toInt() }
        } catch (e: IllegalArgumentException) {
            println(e)
            inputWinningNumbers()
        }

    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        println("\n" + Constants.INPUT_BONUS_NUMBERS)
        return try {
            val bonusNumber = Console.readLine()
            Validation.validateBonusNumber(winningNumbers, bonusNumber)
            bonusNumber.toInt()
        } catch (e: IllegalArgumentException) {
            println(e)
            inputBonusNumber(winningNumbers)
        }
    }
}