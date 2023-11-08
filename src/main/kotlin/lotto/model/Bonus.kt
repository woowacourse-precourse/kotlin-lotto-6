package lotto.model

import lotto.util.Constants
import java.lang.NumberFormatException

class Bonus {
    fun BonusFomatValidate(bonus: String) {
        try {
            bonus.toInt()
        } catch (e: NumberFormatException) {
            println(Constants.ERROR_BONUS_FORMAT)
            throw IllegalArgumentException(Constants.ERROR_BONUS_FORMAT)
        }
    }

    fun BonuDuplicationValidate(bonus: Int, answer: List<Int>) {
        if (answer.contains(bonus)) {
            println(Constants.ERROR_BONUS_DUPLICATION)
            throw IllegalArgumentException(Constants.ERROR_BONUS_DUPLICATION)
        }
    }

    fun BonusRangeValidate(bonus: Int) {
        if (bonus > 45 || bonus < 1) {
            println(Constants.ERROR_BONUS_RANGE)
            throw IllegalArgumentException(Constants.ERROR_BONUS_RANGE)
        }
    }
}