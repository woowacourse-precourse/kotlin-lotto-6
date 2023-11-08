package lotto.domain

import lotto.constants.Constant.Companion.LOTTO_SIZE
import lotto.constants.Exception.Companion.EXCEPTION_DUPLICATED_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE)
        checkDuplication(numbers)
    }

    private fun checkDuplication(numbers: List<Int>) {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException(EXCEPTION_DUPLICATED_NUMBER)
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}