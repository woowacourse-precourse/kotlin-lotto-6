package lotto.model

import lotto.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        Validator().isUserWinningNumbersCheck(numbers)
    }

    val getNumbers: List<Int>
        get() {
            return numbers
        }
}