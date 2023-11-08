package lotto.domain.model

import lotto.domain.enum.error.Error
import lotto.domain.enum.number.UnitNumber

class Winning(val numbers: List<Int>, val bonusNumber: Int) {
    init {
        val lottoNumberRange = UnitNumber.MIN_LOTTO_NUMBER.number..UnitNumber.MAX_LOTTO_NUMBER.number
        require(numbers.size == UnitNumber.LOTTO_COUNT.number) { println(Error.INPUT_FORM.message) }
        require(numbers.all { number -> (lottoNumberRange).contains(number) }) { println(Error.INPUT_FORM.message) }
        require(numbers.distinct().size == UnitNumber.LOTTO_COUNT.number) { println(Error.INPUT_FORM.message) }
        require(lottoNumberRange.contains(bonusNumber)) { println(Error.INPUT_FORM.message) }
        require(!numbers.contains(bonusNumber)) { println(Error.INPUT_FORM.message) }
    }

}