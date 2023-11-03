package lotto.model

import org.mockito.stubbing.Answer
import java.lang.NumberFormatException

class Bonus {
    fun BonusFomatValidate(bonus: String) {
        try {
            bonus.toInt()
        } catch (e: NumberFormatException) {
            println(Constants.ERROR_BONUS_FORMAT)
        }
    }
    fun BonuDuplicationValidate(bonus: Int,answer: List<Int>) {
        if (answer.contains(bonus))
            throw IllegalArgumentException(Constants.ERROR_BONUS_DUPLICATION)
    }
}