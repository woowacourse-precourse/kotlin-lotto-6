package lotto.model

import lotto.util.Winnings
import kotlin.math.roundToInt

class LottoProfit {
    private var _rate = 0.0
    val rate: String
        get() = String.format("%.1f%%", _rate)


    private fun getTotalGain(rankings: List<Int>): Int {
        return rankings[0] * Winnings.RANKING_1ST.price +
                rankings[1] * Winnings.RANKING_2ST.price +
                rankings[2] * Winnings.RANKING_3ST.price +
                rankings[3] * Winnings.RANKING_4ST.price +
                rankings[4] * Winnings.RANKING_5ST.price
    }

    fun calculateRate(rankings: List<Int>, purchasePrice: Int) {
        val totalGain = getTotalGain(rankings)
        val profit = (totalGain / purchasePrice.toDouble()) * 100
        _rate = (profit * 10).roundToInt() / 10.0
    }
}