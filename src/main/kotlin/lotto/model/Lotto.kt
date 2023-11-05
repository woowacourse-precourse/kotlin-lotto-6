package lotto.model

import lotto.Validation.validateDuplicateNumber
import lotto.Validation.validateLottoNumber

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        validateDuplicateNumber(numbers)
        numbers.forEach { validateLottoNumber(it.toString()) }
    }

    fun printLotto() {
        println(numbers.joinToString(", ", "[", "]"))
    }
}
