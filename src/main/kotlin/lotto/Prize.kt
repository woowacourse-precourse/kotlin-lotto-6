package lotto

enum class Prize(val amount: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NOTHING(0);

    companion object {
        fun findPrizeResult(matchedNumberCount: Int, hasBonusNumber: Boolean): Prize {
            return when (matchedNumberCount) {
                6 -> FIRST
                5 -> if (hasBonusNumber) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NOTHING
            }
        }

        fun findPrizeMatchNumberCount(prize: Prize): Int {
            return when (prize) {
                FIRST -> 6
                SECOND -> 5
                THIRD -> 5
                FOURTH -> 4
                FIFTH -> 3
                else -> 0
            }
        }
    }
}