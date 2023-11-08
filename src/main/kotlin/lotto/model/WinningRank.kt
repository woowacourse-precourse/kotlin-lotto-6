package lotto.model

import lotto.utils.Constants.FIFTH_RANK_MATCH_COUNT
import lotto.utils.Constants.FIFTH_RANK_PRIZE_MONEY
import lotto.utils.Constants.FIRST_RANK_MATCH_COUNT
import lotto.utils.Constants.FIRST_RANK_PRIZE_MONEY
import lotto.utils.Constants.FOURTH_RANK_MATCH_COUNT
import lotto.utils.Constants.FOURTH_RANK_PRIZE_MONEY
import lotto.utils.Constants.NONE_MATCH_COUNT
import lotto.utils.Constants.NONE_PRIZE_MONEY
import lotto.utils.Constants.SECOND_AND_THIRD_RANK_MATCH_COUNT
import lotto.utils.Constants.SECOND_RANK_PRIZE_MONEY
import lotto.utils.Constants.THIRD_RANK_PRIZE_MONEY

enum class WinningRank(val matchCount: Int, val prizeMoney: Int, val isBonusMatch: Boolean) {
    NONE(NONE_MATCH_COUNT, NONE_PRIZE_MONEY, false),
    FIFTH(FIFTH_RANK_MATCH_COUNT, FIFTH_RANK_PRIZE_MONEY, false),
    FOURTH(FOURTH_RANK_MATCH_COUNT, FOURTH_RANK_PRIZE_MONEY, false),
    THIRD(SECOND_AND_THIRD_RANK_MATCH_COUNT, THIRD_RANK_PRIZE_MONEY, false),
    SECOND(SECOND_AND_THIRD_RANK_MATCH_COUNT, SECOND_RANK_PRIZE_MONEY, true),
    FIRST(FIRST_RANK_MATCH_COUNT, FIRST_RANK_PRIZE_MONEY, false)
}