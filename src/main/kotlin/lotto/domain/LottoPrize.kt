package lotto.domain

enum class LottoPrize(
    val prize: Int,
    private val matchCount: Int
) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    companion object {

        private val lottoPrizes = entries.toList()

        fun of(matchCount: Int, hasBonusNumber: Boolean) =
            if (matchCount == SECOND.matchCount) {
                if (hasBonusNumber) SECOND else THIRD
            } else if (matchCount == FIRST.matchCount) {
                FIRST
            } else if (matchCount == THIRD.matchCount) {
                THIRD
            }else if (matchCount == FOURTH.matchCount) {
                FOURTH
            }else if (matchCount == FIFTH.matchCount) {
                FIFTH
            }else if (matchCount == NONE.matchCount) {
                NONE
            } else {
                NONE
            }
    }

}