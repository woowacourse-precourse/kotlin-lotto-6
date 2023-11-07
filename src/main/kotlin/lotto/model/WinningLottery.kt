package lotto.model

import lotto.utils.Values

enum class WinningLottery(val winningAmount: Int) {
    FIRST(Values.WINNING_PRIZE_FIRST),
    SECOND(Values.WINNING_PRIZE_SECOND),
    THIRD(Values.WINNING_PRIZE_THIRD),
    FOURTH(Values.WINNING_PRIZE_FOURTH),
    FIFTH(Values.WINNING_PRIZE_FIFTH);
}