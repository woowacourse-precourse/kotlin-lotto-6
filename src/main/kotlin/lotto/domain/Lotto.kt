package lotto.domain

import lotto.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == numbers.size)
        require(numbers.all { number ->
            number in Constants.NUMBER_START_RANGE..Constants.NUMBER_END_RANGE
        })
    }

    fun hasNumber(number: Int): Boolean = numbers.contains(number)

    fun getNumbers(): List<Int> = numbers

    override fun toString(): String {
        return numbers.sorted().toString()
    }
}
