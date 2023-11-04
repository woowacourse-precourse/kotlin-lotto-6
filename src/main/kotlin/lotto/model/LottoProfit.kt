package lotto.model

import kotlin.math.roundToInt

class LottoProfit {
    private var _rate = 0.0
    val rate: Double
        get() = _rate

    private fun getTotalGain(rankings: List<Int>): Int {
        return rankings[0] * 2000000000 + rankings[1] * 30000000 + rankings[2] * 1500000 + rankings[3] * 50000 + rankings[4] * 5000
    }

    fun calculateRate(rankings: List<Int>, purchasePrice: Int) {
        val totalGain = getTotalGain(rankings)
        val profit = (totalGain / purchasePrice.toDouble()) * 100
        _rate = (profit * 10).roundToInt() / 10.0
    }
}