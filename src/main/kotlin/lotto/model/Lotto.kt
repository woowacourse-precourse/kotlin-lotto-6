package lotto.model

import lotto.LOTTO_NUMBER_COUNT
import lotto.exception.DuplicatedNumberException
import lotto.exception.UnvalidLottoNumberException

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT)
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }

}
