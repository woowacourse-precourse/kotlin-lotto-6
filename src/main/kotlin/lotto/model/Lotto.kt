package lotto.model

import lotto.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        Validator().isUserWinningNumbersCheck(numbers)
    }

    val getNumber: List<Int>
        get() = numbers


}