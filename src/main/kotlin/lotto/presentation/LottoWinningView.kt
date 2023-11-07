package lotto.presentation

import SPLIT_COMMA
import WINNING_NUMBER_MESSAGE
import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

object LottoWinningView {
    fun printWinningNumberOfLotto() {
        println(WINNING_NUMBER_MESSAGE)
    }

    fun inputWinningNumberOfLotto() {
        val winningNumber = Console.readLine().trim().split(SPLIT_COMMA)
        LottoController().validateInputWinningNumberNumeric(winningNumber)
    }
}