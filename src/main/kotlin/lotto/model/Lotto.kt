package lotto.model

import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.filter { number -> number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }.size == 6)
    }

    fun getLottoNumbers() = numbers
}
