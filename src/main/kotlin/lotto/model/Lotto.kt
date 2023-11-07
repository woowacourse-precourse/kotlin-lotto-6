package lotto.model

import lotto.util.ValidationUtil

class Lotto(private val numbers: List<Int>) {
    init {
        ValidationUtil.checkLottoNumbers(numbers)
    }

    fun getNumber(): List<Int> {
        return numbers
    }
}
