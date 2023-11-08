package lotto.domain.model

import lotto.domain.enum.error.Error

class Winning(val numbers: List<Int>, val bonusNumber: Int) {
    init {
        require(numbers.size == 6) { println(Error.INPUT_FORM.message) }
        require(numbers.all { number -> (1..45).contains(number) }) { println(Error.INPUT_FORM.message) }
        require(numbers.distinct().size == 6) { println(Error.INPUT_FORM.message) }
        require((1..45).contains(bonusNumber)) { println(Error.INPUT_FORM.message) }
        require(!numbers.contains(bonusNumber)) { println(Error.INPUT_FORM.message) }
    }

}