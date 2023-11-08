package lotto.calculator

import lotto.LottoRank

class LottoPrizeCalculator {
    fun calculate(lottoRanks: List<LottoRank>): Long {
        return lottoRanks.sumOf { it.prize.toLong() }
    }
}