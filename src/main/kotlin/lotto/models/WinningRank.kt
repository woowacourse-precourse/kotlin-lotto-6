package lotto.models

enum class WinningRank(val number: Int, val amount: Int, val count: Int, val isWithBonus: Boolean = false) {
    NOTHING(0, 0, 0),
    SIX(1, 2000000000, 6),
    FIVE_WITH_BONUS(2,30000000, 5, true),
    FIVE(3, 1500000, 5),
    FOUR(4, 50000, 4),
    THREE(5, 5000, 3);

    companion object {
        fun find(matchedCount: Int, isMatchedBonus: Boolean = false): WinningRank = NOTHING

        fun getSortedWinnings(): List<WinningRank> {
            return entries.sortedWith(
                compareBy({ it.count }, { it.isWithBonus })
            )
        }
    }
}