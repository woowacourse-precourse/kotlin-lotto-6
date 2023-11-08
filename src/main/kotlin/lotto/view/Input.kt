package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validation

class Input {

    fun inputPurchaseAmount(): Int {
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