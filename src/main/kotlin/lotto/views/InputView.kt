package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.domain.*

object InputView {
    fun enterMoney(): Int {
        while (true) {
            val input = Console.readLine()
            try {
                moneyErrorCheck(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun enterWinningNumber(): List<Int> {
        while (true) {
            val input = Console.readLine()
            val splitInput = input.split(",")
            try {
                return winningNumberErrorCheck(input, splitInput)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun enterBonusNumber(winningNumber: List<Int>): Int {
        while (true) {
            val bonus = Console.readLine()
            try {
                return bonusNumberErrorCheck(winningNumber, bonus)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }
}