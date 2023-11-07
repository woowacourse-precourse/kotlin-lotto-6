package lotto.model

import lotto.model.seller.Money

class PrizeReceipt(private val cost: Money) {

    private val countByRank = mutableMapOf<Rank, Int>()

    val rate: Double get() = getRateResult()

    fun recordRank(rank: Rank) {
        val currentCount = countByRank[rank] ?: INITIAL_COUNT
        countByRank[rank] = currentCount + 1
    }

    fun getCountByRank(rank: Rank): Int = countByRank[rank] ?: 0

    private fun getRateResult(): Double {
        val sum = getPrizeSum()
        if (sum == 0) return 0.0
        return 100 + ((sum - cost.value) / cost.value.toDouble()) * 100
    }

    private fun getPrizeSum(): Int =
        countByRank.map { (rank, count) -> rank.prize.value * count }.sum()

    companion object {
        private const val INITIAL_COUNT = 0
    }
}