package lotto.model

import lotto.LOTTO_NUMBER_COUNT
import lotto.exception.DuplicatedNumberException
import lotto.exception.UnvalidLottoNumberException
import lotto.utility.Utils

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT)
        checkDuplicatesLottoNumber()
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }

    fun checkDuplicatesLottoNumber() {
        val distinctList = numbers.distinct()

        if (numbers.size != distinctList.size)
            throw DuplicatedNumberException()
    }
}
