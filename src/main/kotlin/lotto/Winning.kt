package lotto

enum class Winning(val amount: Int, val count: Int, val isWithBonus: Boolean = false) {
    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    FIVE_WITH_BONUS(30000000, 5, true),
    SIX(2000000000, 6);

    companion object {
        fun get(matchedCount: Int, isMatchedBonus: Boolean): Winning? =
            entries.find { it.count == matchedCount && it.isWithBonus == isMatchedBonus }

        fun getSortedWinnings(): List<Winning> {
            return entries.sortedWith(
                compareBy({ it.count }, { it.isWithBonus })
            )
        }
    }
}