package lotto.model

import lotto.util.Constants.LOTTO_SIZE
import lotto.util.Constants.RANKING_NOTHING

class LottoRankings {
    private var _rank = mutableListOf<Int>()
    val rank: List<Int>
        get() = _rank

    init {
        _rank = MutableList(LOTTO_SIZE - 1) { 0 }
    }

    fun addRanking(ranking: Int) {
        if (ranking != RANKING_NOTHING) _rank[ranking]++
    }
}