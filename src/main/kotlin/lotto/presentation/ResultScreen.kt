package lotto.presentation

import lotto.domain.Prize

class ResultScreen {
    fun outputResultMessage() = println(LINE_SEPARATOR + WIN_RESULT_START_MESSAGE)

    fun outputWinningResult(countEachPrize: Map<Prize, Int>) =
        println(Prize.entries.filterNot { it == Prize.NONE }.joinToString(LINE_SEPARATOR) { prize ->
            String.format(prize.winningResult, countEachPrize.getOrDefault(prize, DEFAULT_VALUE))
        })


    fun outputWinningRate(winRate: String) = println(TOTAL_WIN_RATE.format(winRate))

    companion object {
        const val WIN_RESULT_START_MESSAGE = "당첨통계\n---"
        const val TOTAL_WIN_RATE = "총 수익률은 %s%%입니다."
        const val LINE_SEPARATOR = "\n"
        const val DEFAULT_VALUE = 0
    }
}