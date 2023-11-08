package lotto.calculator

import lotto.LottoRank

class LottoRankCounter {
    fun count(lottoRanks: List<LottoRank>): Map<LottoRank, Int> {
        return lottoRanks.groupBy { it }
            .mapValues { it.value.size }
    }
}