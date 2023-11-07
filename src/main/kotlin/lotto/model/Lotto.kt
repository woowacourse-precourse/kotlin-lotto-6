package lotto.model

import lotto.constants.LottoConstants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.filter { number ->
                number in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER
            }.size == 6
        )
    }

    fun getLottoNumbers() = numbers
}
