package lotto.domain

import lotto.constants.fifthPrize
import lotto.constants.firstPrize
import lotto.constants.fourthPrize
import lotto.constants.secondPrize
import lotto.constants.thirdPrize

enum class Rank(val hit: Int, val bonusHit: Boolean, val prize: Int) {
    FIRST(6, false, firstPrize),
    SECOND(5, true, secondPrize),
    THIRD(5, false, thirdPrize),
    FOURTH(4, false, fourthPrize),
    FIFTH(3, false, fifthPrize),
    NOTHING(0, false, 0);

    companion object {
        fun of(hit: Int, bonusHit: Boolean): Rank {
            return values().firstOrNull { it.hit == hit && it.bonusHit == bonusHit } ?: NOTHING
        }
    }
}