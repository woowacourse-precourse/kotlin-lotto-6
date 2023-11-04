package lotto.model

class LottoRankings {
    private var _rank = mutableListOf<Int>()
    val rank: List<Int>
        get() = _rank

    init {
        _rank = MutableList(5) { 0 }
    }

    fun addRanking(ranking: Int) {
        when (ranking) {
            6 -> _rank[0]++
            -1 -> _rank[1]++
            5 -> _rank[2]++
            4 -> _rank[3]++
            3 -> _rank[4]++
        }
    }
}