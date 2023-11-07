package lotto.domain

enum class LottoRank(private val matchCount: Int, val prize: Int) {
    OUT_OF_RANK(-1, 0),
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    companion object {
        fun fromMatches(matches: Int, bonus: Boolean): LottoRank {
            return when {
                matches == 6 -> FIRST_PLACE
                matches == 5 && bonus -> SECOND_PLACE
                matches == 5 -> THIRD_PLACE
                matches == 4 -> FOURTH_PLACE
                matches == 3 -> FIFTH_PLACE
                else -> OUT_OF_RANK
            }
        }
    }

    override fun toString(): String {
        return when (this) {
            SECOND_PLACE -> "5개 일치, 보너스 볼 일치 (${prize.toFormattedString()})"
            else -> "${matchCount}개 일치 (${prize.toFormattedString()})"
        }
    }

    private fun Int.toFormattedString(): String = String.format("%,d원", this)
}