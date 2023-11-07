package lotto.domain

import lotto.util.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        validate()
    }

    fun getLottoNumbers() = numbers

    private fun validate() = Exception.validateLottoNumber(numbers)
}
