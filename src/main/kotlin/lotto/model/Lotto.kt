package lotto.model

import lotto.Validation.validateDuplicateNumber

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        validateDuplicateNumber(numbers)
    }

    fun printLotto() {
        println(numbers.joinToString(", ", "[", "]"))
    }
}
