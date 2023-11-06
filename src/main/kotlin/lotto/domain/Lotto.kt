package lotto.domain

import lotto.constants.LOTTO_SIZE
import lotto.constants.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE)
        validateDuplication()
        validateAscendingOrder()
    }

    // TODO: 추가 기능 구현
    fun getLotto(): List<Int> {
        return numbers
    }

    private fun validateDuplication() {
        if(numbers.distinct().size != LOTTO_SIZE) throw IllegalArgumentException(MESSAGE_DUPLICATE_NUMBER)
    }

    private fun validateAscendingOrder() {
        for (i in 1 until numbers.size) {
            if (numbers[i] < numbers[i - 1]) throw IllegalArgumentException(MESSAGE_DUPLICATE_NUMBER)
        }
    }
}
