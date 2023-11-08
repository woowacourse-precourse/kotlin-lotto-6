package lotto.model

import lotto.util.Validator.validateDuplicate
import lotto.util.Validator.validateRange

class Bonus(private val _number: Int) {
    val number: Int
        get() = _number

    init {
        validateRange(_number)
    }

    fun checkDuplication (numbers: List<Int>) {
        validateDuplicate(numbers, _number)
    }
}