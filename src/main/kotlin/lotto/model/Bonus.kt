package lotto.model


import lotto.util.Validator.validateContain
import lotto.util.Validator.validateNumberRange

class Bonus(private val _number: Int) {
    val number: Int
        get() = _number

    init {
        validateNumberRange(_number)
    }

    fun checkUniqueNumber(numbers: List<Int>) {
        validateContain(numbers, _number)
    }
}