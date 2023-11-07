package lotto.presentation

import WINNING_NUMBER_MESSAGE
import camp.nextstep.edu.missionutils.Console

object LottoWinningView {
    fun printWinningNumberOfLotto() {
        println(WINNING_NUMBER_MESSAGE)
    }

    fun inputWinningNumberOfLotto() {
        val winningNumber = Console.readLine()
    }
}