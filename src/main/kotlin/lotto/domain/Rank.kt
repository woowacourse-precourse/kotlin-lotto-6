package lotto.domain

enum class Rank(val matchCount: Int, val reward: Int) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun findRankByMatchCountAndBonus(matchCount: Int, hasBonus: Boolean): Rank? {
            return when (matchCount) {
                6 -> FIRST
                5 -> when (hasBonus) {
                    true -> SECOND
                    else -> THIRD
                }

                4 -> FOURTH
                3 -> FIFTH
                else -> null
            }
        }
    }
}
