package lotto

import lotto.GameMessageConstants.FIVE_MATCHES
import lotto.GameMessageConstants.FIVE_MATCHES_WITH_BONUS_BALL
import lotto.GameMessageConstants.FOUR_MATCHES
import lotto.GameMessageConstants.SIX_MATCHES
import lotto.GameMessageConstants.THREE_MATCHES

enum class Rank(
    val countOfMatch: Int,
    val prize: Long,
    val matchBonus: Boolean,
    val description: String,
) {
    FIFTH(3, 5_000, false, THREE_MATCHES),
    FOURTH(4, 50_000, false, FOUR_MATCHES),
    THIRD(5, 1_500_000, false, FIVE_MATCHES),
    SECOND(5, 30_000_000, true, FIVE_MATCHES_WITH_BONUS_BALL),
    FIRST(6, 2_000_000_000, false, SIX_MATCHES),
    ;

    companion object {
        fun findRank(countOfMatch: Int, matchBonus: Boolean): Rank? {
            return values().find { it.countOfMatch == countOfMatch && it.matchBonus == matchBonus }
        }
    }
}
