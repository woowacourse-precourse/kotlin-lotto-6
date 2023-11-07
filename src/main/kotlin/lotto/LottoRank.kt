package lotto

enum class LottoRank(val matchCount: Int, val prize: Int, bonusMatch: Boolean) {
    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    companion object {
        fun fromMatchCount(matchCount: Int): LottoRank {
            return entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}

