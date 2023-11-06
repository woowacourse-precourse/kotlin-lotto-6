package lotto.model

import lotto.util.Constants.FIRST_DECIMAL_PLACE
import lotto.util.Winnings

class LottoProfit(
    private val rankings: List<Int>,
    private val purchasePrice: Int
) {
    val rate: String

    init {
        val profit = calculateRate(rankings, purchasePrice)
        rate = String.format(FIRST_DECIMAL_PLACE, profit)
    }


    private fun getTotalGain(rankings: List<Int>): Int {
        return rankings[0] * Winnings.RANKING_1ST.price +
                rankings[1] * Winnings.RANKING_2ST.price +
                rankings[2] * Winnings.RANKING_3ST.price +
                rankings[3] * Winnings.RANKING_4ST.price +
                rankings[4] * Winnings.RANKING_5ST.price
    }

    private fun calculateRate(rankings: List<Int>, purchasePrice: Int): Double {
        val totalGain = getTotalGain(rankings)
        val profit = (totalGain / purchasePrice.toDouble()) * 100
        return profit
    }
}