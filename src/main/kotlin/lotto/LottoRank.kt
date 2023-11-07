package lotto

enum class LottoRank(val matchCount: Int, val prize: Int) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000,),
    FIRST(6, 2_000_000_000);

    companion object {
        fun fromMatchCount(matchCount: Int): LottoRank {
            return entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}

