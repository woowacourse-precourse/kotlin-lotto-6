package lotto.model

enum class Rank(val matchCnt: Int, val winningMoney: Int) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun of(matchCnt: Int, matchBonusCnt: Boolean) : Rank {
            val rank: List<Rank> = values().filter {it.matchCnt == matchCnt }
            if(rank.size == 2 && matchBonusCnt) return rank[1]
            if (rank.isEmpty()) return NONE
            return rank[0]
        }
    }
}
