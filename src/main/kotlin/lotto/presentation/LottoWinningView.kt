package lotto.presentation

import lotto.util.PROFIT_RATE_TEXT
import lotto.util.WINNING_RESULT_FIVE_BONUS_TEXT
import lotto.util.WINNING_RESULT_FIVE_TEXT
import lotto.util.WINNING_RESULT_FOUR_TEXT
import lotto.util.WINNING_RESULT_SIX_TEXT
import lotto.util.WINNING_RESULT_THREE_TEXT
import lotto.util.WINNING_STATISTICS_TEXT

object LottoWinningView {
    fun printWinningStatic() {
        println("$WINNING_STATISTICS_TEXT\n---")
    }

    fun outputThreeWinningResult(winningCount: Int) {
        println("$WINNING_RESULT_THREE_TEXT${winningCount}개")
    }

    fun outputFourWinningResult(winningCount: Int) {
        println("$WINNING_RESULT_FOUR_TEXT${winningCount}개")
    }

    fun outputFiveWinningResult(winningCount: Int) {
        println("$WINNING_RESULT_FIVE_TEXT${winningCount}개")
    }

    fun outputFiveBonusWinningResult(winningCount: Int) {
        println("${WINNING_RESULT_FIVE_BONUS_TEXT}${winningCount}개")
    }

    fun outputSixWinningResult(winningCount: Int) {
        println("$WINNING_RESULT_SIX_TEXT${winningCount}개")
    }

    fun outputProfitRate(profit: String) {
        println(PROFIT_RATE_TEXT.format(profit))
    }

}