package lotto.domain

import lotto.constants.fifthPrize
import lotto.constants.firstPrize
import lotto.constants.fourthPrize
import lotto.constants.secondPrize
import lotto.constants.thirdPrize

enum class Rank(val hit: Int, val bonusHit: Boolean, val prize: Int) {
    FIFTH(3, false, fifthPrize),
    FOURTH(4, false, fourthPrize),
    THIRD(5, false, thirdPrize),
    SECOND(5, true, secondPrize),
    FIRST(6, false, firstPrize),
    NOTHING(0, false, 0);

    companion object {
        fun of(hit: Int, bonusHit: Boolean): Rank {
            return values().firstOrNull { it.hit == hit && it.bonusHit == bonusHit } ?: NOTHING
        }
    }
}