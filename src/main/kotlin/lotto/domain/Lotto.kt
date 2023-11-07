package lotto.domain

import lotto.domain.validator.LottoValidator.validateLottoNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoNumbers(numbers)
    }

    companion object {
        val LOTTO_NUMBER_COUNT = 6
        val LOTTO_MIN_VALUE = 1
        val LOTTO_MAX_VALUE = 45
    }
}
