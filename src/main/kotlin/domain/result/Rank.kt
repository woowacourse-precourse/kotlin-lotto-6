package domain.result

import lotto.constants.Constants.PRIZE_FIFTH
import lotto.constants.Constants.PRIZE_FIRST
import lotto.constants.Constants.PRIZE_FOURTH
import lotto.constants.Constants.PRIZE_SECOND
import lotto.constants.Constants.PRIZE_THIRD

enum class Rank(
    val winningCount: Int,
    val bonus: Boolean,
    val amount: Int,
    val reward: String,
) {
    FIFTH(3, false, 5000, PRIZE_FIFTH),
    FOURTH(4, false, 50000, PRIZE_FOURTH),
    THIRD(5, false, 1500000, PRIZE_THIRD),
    SECOND(5, true, 30000000, PRIZE_SECOND),
    FIRST(6, false, 2000000000, PRIZE_FIRST)
}