package lotto.model

import lotto.utils.Constants.ERROR_INPUT_DUPLICATE
import lotto.utils.Constants.ERROR_INPUT_RANGE
import lotto.utils.Constants.ERROR_INPUT_SIZE
import lotto.utils.Constants.LOTTO_NUMBER_SIZE
import lotto.utils.Constants.MAX_LOTTO_NUMBER
import lotto.utils.Constants.MIN_LOTTO_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_SIZE }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_DUPLICATE }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_INPUT_RANGE }
    }

    fun getNumbers(): List<Int> {
        return numbers.toList()
    }

    override fun toString(): String = numbers.sorted().joinToString(prefix = "[", postfix = "]", separator = ", ")
}
