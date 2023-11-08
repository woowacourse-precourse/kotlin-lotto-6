package lotto.calculator

import lotto.LottoRank
import lotto.model.LottoResult

class LottoResultCalculator(
    private val earningRateCalculator: LottoEarningRateCalculator = LottoEarningRateCalculator(),
    private val prizeCalculator: LottoPrizeCalculator = LottoPrizeCalculator(),
    private val lottoRankCounter: LottoRankCounter = LottoRankCounter()
) {
    fun calculate(buyingPrice: Int, lottoRanks: List<LottoRank>): LottoResult {
        val rankCounts = lottoRankCounter.count(lottoRanks)
        val totalPrize = prizeCalculator.calculate(lottoRanks)
        val earningsRate = earningRateCalculator.calculate(buyingPrice, totalPrize)
        return LottoResult(rankCounts, earningsRate)
    }
}