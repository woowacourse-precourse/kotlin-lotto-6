package domain.result

import lotto.constants.Constants.PRIZE_FIFTH
import lotto.constants.Constants.PRIZE_FIRST
import lotto.constants.Constants.PRIZE_FOURTH
import lotto.constants.Constants.PRIZE_SECOND
import lotto.constants.Constants.PRIZE_THIRD

enum class Rank(
    val winningCount: Int,
    val bonus: Boolean,
    val reward: String,
) {
    FIFTH(3, false, PRIZE_FIFTH),
    FOURTH(4, false, PRIZE_FOURTH),
    THIRD(5, false, PRIZE_THIRD),
    SECOND(5, true, PRIZE_SECOND),
    FIRST(6, false, PRIZE_FIRST)
}