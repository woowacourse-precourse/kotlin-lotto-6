package lotto.model

import lotto.util.GameConstants.NO_RANK
import lotto.util.GameConstants.RANK

class Ranking {
    private var _rank = mutableListOf<Int>()

    val rank: List<Int>
        get() = _rank

    init {
        _rank = MutableList(RANK) {0}
    }

    fun countRanking(ranking: Int) {
        if (ranking != NO_RANK) {
            _rank[ranking]++
        }
    }
}