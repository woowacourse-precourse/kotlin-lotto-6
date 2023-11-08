package lotto.presentation

import SPLIT_COMMA
import WINNING_NUMBER_MESSAGE
import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

object LottoWinningView {
    fun printWinningNumberOfLotto() {
        println(WINNING_NUMBER_MESSAGE)
    }

    fun inputWinningNumberOfLotto(): List<Int> {
        val winningNumber = Console.readLine().trim().split(SPLIT_COMMA)
        LottoController().validateWinningNumberSize(winningNumber)
        LottoController().validateWinningNumberNumeric(winningNumber)
        LottoController().validateWinningNumberRange(winningNumber.map { it.toInt() })
        LottoController().validateWinningNumberDuplicate(winningNumber.map { it.toInt() })

        return winningNumber.map { it.toInt() }
    }
}