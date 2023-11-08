package lotto.utils

import lotto.utils.Constants.FIFTH_PLACE_ANNOUNCE
import lotto.utils.Constants.FIRST_PLACE_ANNOUNCE
import lotto.utils.Constants.FOURTH_PLACE_ANNOUNCE
import lotto.utils.Constants.SECOND_PLACE_ANNOUNCE
import lotto.utils.Constants.THIRD_PLACE_ANNOUNCE

enum class Statistic(val announceMessage: String) {
    FIRST_PLACE_MESSAGE(FIRST_PLACE_ANNOUNCE),
    SECOND_PLACE_MESSAGE(SECOND_PLACE_ANNOUNCE),
    THIRD_PLACE_MESSAGE(THIRD_PLACE_ANNOUNCE),
    FOURTH_PLACE_MESSAGE(FOURTH_PLACE_ANNOUNCE),
    FIFTH_PLACE_MESSAGE(FIFTH_PLACE_ANNOUNCE)
}