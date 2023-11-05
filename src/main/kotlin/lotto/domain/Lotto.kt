package lotto.domain

import lotto.util.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        Exception.validateLottoNumber(numbers)
    }

    fun getLottoNumbers() = numbers
}
