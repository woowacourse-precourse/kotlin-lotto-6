package lotto.domain

import kotlin.math.roundToInt

class LottoResult(private val result: Map<Rank, Int>) {
    private fun computeTotalPrizeMoney(): Int {
        return result.entries.sumOf { it.key.prize * it.value }
    }

    fun computeGrossProfit(
        initialCapital: Int,
        totalPrize: Int = computeTotalPrizeMoney()
    ): Double {
        return (totalPrize.toFloat() / initialCapital.toFloat() * 1000).roundToInt() / 10.0
    }

    fun getResult(): Map<Rank, Int> {
        return result
    }
}