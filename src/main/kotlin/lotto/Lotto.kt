package lotto

import lotto.domain.service.LottoCalculator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getNumbers() = numbers

}
