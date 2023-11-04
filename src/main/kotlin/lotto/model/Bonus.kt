package lotto.model


import lotto.util.Validator.validateContain
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateNotNull
import lotto.util.Validator.validateNumberRange

class Bonus(private val bonus: String) {
    init {
        validateNotNull(bonus)
        validateInteger(bonus)
        validateNumberRange(bonus.toInt())
    }

    fun checkUniqueNumber(numbers: List<Int>) {
        validateContain(numbers, bonus.toInt())
    }

    fun getNumber(): Int = bonus.toInt()
}