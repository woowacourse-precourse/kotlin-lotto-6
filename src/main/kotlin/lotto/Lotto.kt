package lotto

import lotto.domain.enum.number.UnitNumber
import lotto.domain.service.LottoCalculator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == UnitNumber.LOTTO_COUNT.number)
    }

    fun getNumbers() = numbers

}
