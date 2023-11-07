package lotto.model

import lotto.utils.Constants

enum class Prize(val message: String, val prizeAmount: Int) {
    THREE_MATCH(Constants.THREE_MATCH_MESSAGE, Constants.THREE_AMOUNT),
    FOUR_MATCH(Constants.FOUR_MATCH_MESSAGE, Constants.FOUR_AMOUNT),
    FIVE_MATCH(Constants.FIVE_MATCH_MESSAGE, Constants.FIVE_AMOUNT),
    FIVE_MATCH_WITH_BONUS(Constants.FIVE_BONUS_MATCH_MESSAGE, Constants.FIVE_WITH_BONUS_AMOUNT),
    SIX_MATCH(Constants.SIX_MESSAGE, Constants.SIX_AMOUNT)
}