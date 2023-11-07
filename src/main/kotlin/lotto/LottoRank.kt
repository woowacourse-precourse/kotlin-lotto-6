package lotto

enum class LottoRank(val prize: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    companion object {
        fun of(matchedCount: Int, hasBonusNumber: Boolean): LottoRank {
            return when {
                matchedCount == 6 -> FIRST
                matchedCount == 5 && hasBonusNumber -> SECOND
                matchedCount == 5 -> THIRD
                matchedCount == 4 -> FOURTH
                matchedCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}