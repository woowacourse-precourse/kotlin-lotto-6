package lotto.model

import lotto.Constants.Companion.ERROR_OUT_OF_RANGE_NUMBER_MESSAGE
import lotto.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.Constants.Companion.MIN_LOTTO_NUMBER

class Bonus(private var bonusNumber: Int) {
    init {
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { ERROR_OUT_OF_RANGE_NUMBER_MESSAGE }
    }
    val getBonusNumber: Int
        get() = bonusNumber

}