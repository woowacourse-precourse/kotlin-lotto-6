package lotto.model

import lotto.LottoRank

data class LottoResult(val rankCounts: Map<LottoRank, Int>, val earningsRate: Float)