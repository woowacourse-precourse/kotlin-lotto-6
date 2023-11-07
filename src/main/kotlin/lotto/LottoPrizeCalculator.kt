package lotto

import lotto.model.LottoResult
import kotlin.math.round

class LottoPrizeCalculator {
    fun calculateLottoResult(buyingPrice: Int, lottoRanks: List<LottoRank>): LottoResult {
        val rankCounts = lottoRanks.countEachRank()
        val totalPrize = lottoRanks.sumPrizeValues()
        val earningsRate = (totalPrize.toEarningsRate(buyingPrice)).roundOneStep()
        return LottoResult(rankCounts, earningsRate)
    }

    private fun List<LottoRank>.countEachRank(): Map<LottoRank, Int> {
        return groupBy { it }
            .mapValues { it.value.size }
    }

    private fun List<LottoRank>.sumPrizeValues() = sumOf { it.prize.toLong() }

    private fun Long.toEarningsRate(buyingPrice: Int) = (this / buyingPrice.toFloat()) * HUNDRED

    private fun Float.roundOneStep() = round(this / ONE_STEP) * ONE_STEP

    companion object {
        private const val HUNDRED = 100
        private const val ONE_STEP = 10
    }
}
