package lotto.view

import lotto.model.Lotto
import lotto.utils.Constants.PRINT_ENTER
import lotto.utils.Constants.PRINT_LINE_HYPHEN
import lotto.utils.Constants.PRINT_PRODUCE_LOTTO_RESULT_MESSAGE
import lotto.utils.Constants.PRINT_PROFIT_MESSAGE_BACK
import lotto.utils.Constants.PRINT_PROFIT_MESSAGE_FRONT
import lotto.utils.Constants.WINNING_STATS_MESSAGE
import lotto.utils.Statistic

object OutPutView {
    fun printProduceLottoResult(produceLottoResult: List<Lotto>) {
        println(PRINT_ENTER + "${produceLottoResult.size}" + PRINT_PRODUCE_LOTTO_RESULT_MESSAGE)
        produceLottoResult.forEach { lotto -> println(lotto) }
    }

    fun printLottoRankResult(rankCount: List<Int>) {
        println(PRINT_ENTER + WINNING_STATS_MESSAGE + PRINT_ENTER + PRINT_LINE_HYPHEN)
        printLottoWinningStatistic(rankCount)
    }

    private fun printLottoWinningStatistic(ranking: List<Int>) {
        val placeMessages = listOf(
            Statistic.FIFTH_PLACE_MESSAGE,
            Statistic.FOURTH_PLACE_MESSAGE,
            Statistic.THIRD_PLACE_MESSAGE,
            Statistic.SECOND_PLACE_MESSAGE,
            Statistic.FIRST_PLACE_MESSAGE
        )

        for (i in ranking.indices) {
            println(placeMessages[i].announceMessage.format(ranking[i]))
        }
    }

    fun printProfitResult(profitValue: Double) {
        println(PRINT_PROFIT_MESSAGE_FRONT.format(profitValue) + PRINT_PROFIT_MESSAGE_BACK)
    }
}