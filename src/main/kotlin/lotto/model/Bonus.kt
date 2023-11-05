package lotto.model

import lotto.Validator

class Bonus(lotto: List<Int>, private val bonusNumber: String) {
    init {
        Validator().isUserBonusNumberCheck(lotto, bonusNumber)
    }

    val getBonusNumber: String
        get() = bonusNumber

}