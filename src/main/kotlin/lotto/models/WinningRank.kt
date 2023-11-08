package lotto.models

enum class WinningRank(val number: Int, val amount: Int, val macthCount: Int, val hasBonus: Boolean = false) {
    FIRST(1, 2000000000, 6),
    SECOND(2, 30000000, 5, true),
    THIRD(3, 1500000, 5),
    FOURTH(4, 50000, 4),
    FIFTH(5, 5000, 3),
    NOTHING(0, 0, 0);

    companion object {
        fun find(matchedCount: Int, hasMatchingBonus: Boolean = false): WinningRank =
            WinningRank.entries.find { it.macthCount == matchedCount && it.hasBonus == hasMatchingBonus } ?: NOTHING

        fun getAll(): List<WinningRank> {
            return entries
        }

        fun getAllWithoutNothing(): List<WinningRank> {
            return entries.filter { it != NOTHING }.sortedByDescending { it.number }
        }
    }
}