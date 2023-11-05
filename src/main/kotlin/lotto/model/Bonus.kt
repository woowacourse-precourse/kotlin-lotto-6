package lotto.model

import lotto.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.Constants.Companion.MIN_LOTTO_NUMBER

class Bonus(private val bonusNumber: Int) {
    init {
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
    }
    val getBonusNumber: Int
        get() = bonusNumber

}