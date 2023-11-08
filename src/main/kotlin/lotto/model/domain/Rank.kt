package lotto.model.domain

enum class Rank(val countOfMatch: Int, val isBonus: Boolean, val winningAmount: Int) {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    companion object {
        fun findRank(countOfMatch: Int, isBonus: Boolean): Rank {
            return when (countOfMatch) {
                5 -> if (isBonus) SECOND else THIRD
                else -> entries.find { it.countOfMatch == countOfMatch } ?: NONE
            }
        }
    }
}