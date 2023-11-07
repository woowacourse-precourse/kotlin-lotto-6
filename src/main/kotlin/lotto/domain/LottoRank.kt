package lotto.domain

enum class LottoRank(val matchCount: Int, val prize: Int) {
    NO_MATCH(0, 0),
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_AND_BONUS_MATCHES(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000);

    companion object {
        fun fromMatches(matches: Int, bonus: Boolean): LottoRank {
            return when {
                matches == 6 -> SIX_MATCHES
                matches == 5 && bonus -> FIVE_AND_BONUS_MATCHES
                matches == 5 -> FIVE_MATCHES
                matches == 4 -> FOUR_MATCHES
                matches == 3 -> THREE_MATCHES
                else -> NO_MATCH
            }
        }
    }

    override fun toString(): String {
        return when (this) {
            FIVE_AND_BONUS_MATCHES -> "5개 일치, 보너스 볼 일치 (${prize.toFormattedString()})"
            else -> "${matchCount}개 일치 (${prize.toFormattedString()})"
        }
    }

    private fun Int.toFormattedString(): String = String.format("%,d원", this)
}