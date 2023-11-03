package lotto.model

import java.lang.NumberFormatException

class Bonus {
    fun BonusFomatValidate(bonus: String) {
        try {
            bonus.toInt()
        } catch (e: NumberFormatException) {
            println(Constants.ERROR_BONUS_FORMAT)
        }
    }
}