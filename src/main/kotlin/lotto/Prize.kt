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
            return when {
                matchedNumberCount == WinningBallCount.FIRST.count -> FIRST
                matchedNumberCount == WinningBallCount.SECOND.count && hasBonusNumber -> SECOND
                matchedNumberCount == WinningBallCount.THIRD.count && !hasBonusNumber -> THIRD
                matchedNumberCount == WinningBallCount.FOURTH.count -> FOURTH
                matchedNumberCount == WinningBallCount.FIFTH.count -> FIFTH
                else -> NOTHING
            }
        }
    }
}