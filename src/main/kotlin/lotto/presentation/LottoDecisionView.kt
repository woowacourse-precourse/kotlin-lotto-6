package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.util.BONUS_NUMBER_TEXT
import lotto.util.WINNING_NUMBER_TEXT

object LottoDecisionView {
    fun printWinningNumber() {
        println(WINNING_NUMBER_TEXT)
    }

    fun inputWinningNumber(): List<Int> {
        val winningNumbers = Console.readLine().trim()
        return winningNumbers.split(",").map { it.toInt() }
    }

    fun printBonusNumber() {
        println(BONUS_NUMBER_TEXT)
    }

    fun inputBonusNumber(): Int {
        return Console.readLine().trim().toInt()
    }
}