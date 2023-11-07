package lotto.Model

import lotto.util.Constants.Companion.DUPLICATE_WINNING_NUMBER_COUNT_ERROR_MESSAGE
import lotto.util.Constants.Companion.LOTTO_SIZE

class Lotto(private val numbers: List<Int>) { // 당첨 로또 번호 관리하는 클래스.
    init {
        require(numbers.size == LOTTO_SIZE)
        require(!isDoubleCheck()) { DUPLICATE_WINNING_NUMBER_COUNT_ERROR_MESSAGE }
    }

    private fun isDoubleCheck() = numbers.toSet().size != numbers.size

    fun getNumbers(): List<Int> = numbers
}
