package domain.result

import lotto.constants.Constants.PRIZE_FIFTH
import lotto.constants.Constants.PRIZE_FIRST
import lotto.constants.Constants.PRIZE_FOURTH
import lotto.constants.Constants.PRIZE_SECOND
import lotto.constants.Constants.PRIZE_THIRD

enum class Prize(
    val winning: Int,
    val bonus: Boolean,
    val reward: String,
) {
    FIRST(6, false, PRIZE_FIRST),
    SECOND(5, true, PRIZE_SECOND),
    THIRD(5, false, PRIZE_THIRD),
    FOURTH(4, false, PRIZE_FOURTH),
    FIFTH(3, false, PRIZE_FIFTH);
}