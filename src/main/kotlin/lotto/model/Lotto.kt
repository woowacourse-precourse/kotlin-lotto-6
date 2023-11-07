package lotto.model

import lotto.util.Check.checkWinningNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkWinningNumbers(numbers)
    }

    fun getNumbers() = numbers
}
