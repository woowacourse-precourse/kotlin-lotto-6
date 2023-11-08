package model

import util.LottoValidation

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidation.REQUIRED_LOTTO_NUMBER_COUNT.isValid(numbers)
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(numbers)
        LottoValidation.LOTTO_NUMBER_RANGE.isValid(numbers)
    }

    // TODO: 추가 기능 구현

    fun getNumberInfo() = numbers.sorted()
}
