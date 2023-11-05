package lotto.model

import util.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.INVALID_LOTTO_COUNT }
        require(numbers.toSet().size == 6) { ErrorMessage.DUPLICATED_LOTTO_NUMBER }
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}