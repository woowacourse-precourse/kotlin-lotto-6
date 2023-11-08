package lotto.view

import lotto.Constants.OUTPUT_FIVE_MATCH_MESSAGE
import lotto.Constants.OUTPUT_FIVE_WITH_BONUS_MATCH_MESSAGE
import lotto.Constants.OUTPUT_FOUR_MATCH_MESSAGE
import lotto.Constants.OUTPUT_PROFIT_PERCENTAGE_MESSAGE
import lotto.Constants.OUTPUT_PURCHASE_COUNT_MESSAGE
import lotto.Constants.OUTPUT_SIX_MATCH_MESSAGE
import lotto.Constants.OUTPUT_THREE_MATCH_MESSAGE
import lotto.Constants.OUTPUT_WINNING_STATISTICS_MESSAGE
import lotto.model.LottoRank

class OutputView {

    private val lottoThreeMatch = LottoRank.THREE_MATCH
    private val lottoFourMatch = LottoRank.FOUR_MATCH
    private val lottoFiveMatch = LottoRank.FIVE_MATCH
    private val lottoFiveWithBonusMatch = LottoRank.FIVE_MATCH_WITH_BONUS
    private val lottoSixMatch = LottoRank.SIX_MATCH

    fun ticketCountMessage(ticket: Int) {
        println("\n" + String.format(OUTPUT_PURCHASE_COUNT_MESSAGE, ticket))
    }

    fun winningStatisticsMessage() {
        println("\n" + OUTPUT_WINNING_STATISTICS_MESSAGE)
        println("---")
        println(String.format(OUTPUT_THREE_MATCH_MESSAGE, lottoThreeMatch.getCount()))
        println(String.format(OUTPUT_FOUR_MATCH_MESSAGE, lottoFourMatch.getCount()))
        println(String.format(OUTPUT_FIVE_MATCH_MESSAGE, lottoFiveMatch.getCount()))
        println(String.format(OUTPUT_FIVE_WITH_BONUS_MATCH_MESSAGE, lottoFiveWithBonusMatch.getCount()))
        println(String.format(OUTPUT_SIX_MATCH_MESSAGE, lottoSixMatch.getCount()))
    }

    fun profitPercentageMessage(profitPercentage: Double) {
        println(String.format(OUTPUT_PROFIT_PERCENTAGE_MESSAGE, profitPercentage))
    }

    fun randomLottoLists(lottoList: MutableMap<Int, List<Int>>) {
        lottoList.values.forEach { value ->
            println(value)
        }
    }
}