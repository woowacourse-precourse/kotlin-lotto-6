package lotto.model

import lotto.constants.LottoConstants.LOTTO_COUNT
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT)
        require(numbers.filter { number -> number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }.size == LOTTO_COUNT)
        require(numbers.distinct().size == LOTTO_COUNT)
    }

    fun getLottoNumbers() = numbers
}
