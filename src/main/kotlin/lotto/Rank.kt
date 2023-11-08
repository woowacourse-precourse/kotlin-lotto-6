package lotto

enum class Rank(val matchCount: Int, val prize: Int, val hasBonus: Boolean = false) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    companion object {
        fun lottoResult(matchCount: Int, matchBonus: Boolean): Rank {
            if (matchCount in 0..2)
                return NONE

            if (matchCount == 5 && matchBonus) {
                return SECOND
            }

            return entries.find { rank ->
                rank.matchCount == matchCount && !rank.hasBonus
            } ?: NONE
        }
    }
}