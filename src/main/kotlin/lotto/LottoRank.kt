package lotto

enum class LottoRank(val matchCount: Int, val prize: Int) {
    FIRST(6, 100000000),
    SECOND(5, 50000000),
    THIRD(4, 1000000),
    FOURTH(3, 50000),
    FIFTH(2, 5000),
    NONE(0, 0);

    companion object {
        fun fromMatchCount(matchCount: Int): LottoRank {
            return entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}
