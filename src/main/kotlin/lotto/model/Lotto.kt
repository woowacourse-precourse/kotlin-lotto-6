package lotto.model

import lotto.utils.Constant.DUPLICATE_WINNING_NUMBER_COUNT_ERROR_MESSAGE
import lotto.utils.Constant.LOTTO_SIZE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE)
        require(!isDoubleCheck()) { DUPLICATE_WINNING_NUMBER_COUNT_ERROR_MESSAGE }
    }

    private fun isDoubleCheck() = numbers.toSet().size != numbers.size

    fun getNumbers(): List<Int> = numbers
}
