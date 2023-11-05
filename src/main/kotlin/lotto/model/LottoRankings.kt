package lotto.model

import lotto.util.Constants.LOTTO_SIZE

class LottoRankings {
    private var _rank = mutableListOf<Int>()
    val rank: List<Int>
        get() = _rank

    init {
        _rank = MutableList(LOTTO_SIZE - 1) { 0 }
    }

    fun addRanking(ranking: Int) = _rank[ranking]++

}