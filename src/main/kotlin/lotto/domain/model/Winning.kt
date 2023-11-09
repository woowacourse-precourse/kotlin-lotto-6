package lotto.domain.model

import lotto.domain.enum.error.WinningNumberError
import lotto.domain.enum.number.UnitNumber

class Winning(val numbers: List<Int>, val bonusNumber: Int) {
    init {
        val lottoNumberRange = UnitNumber.MIN_LOTTO_NUMBER.number..UnitNumber.MAX_LOTTO_NUMBER.number
        require(numbers.size == UnitNumber.LOTTO_COUNT.number) { println(WinningNumberError.COUNT.message) }
        require(numbers.all { number -> lottoNumberRange.contains(number) }) { println(WinningNumberError.RANGE.message) }
        require(lottoNumberRange.contains(bonusNumber)) { println(WinningNumberError.RANGE.message) }
        require(numbers.distinct().size == UnitNumber.LOTTO_COUNT.number) { println(WinningNumberError.DUPLICATION.message) }
        require(!numbers.contains(bonusNumber)) { println(WinningNumberError.DUPLICATION.message) }
    }

}