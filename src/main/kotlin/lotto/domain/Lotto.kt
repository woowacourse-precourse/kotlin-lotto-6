package lotto.domain

import lotto.Constants.LOTTO_COUNT

class Lotto(private val numbers: List<Int>) {

    private val numbersSet = numbers.toSet()
    init {
        require(numbers.size == LOTTO_COUNT)
        require(numbersSet.size == LOTTO_COUNT)
    }
    private fun sorted() = numbers.sorted()
    override fun toString(): String {
        return sorted().joinToString(", ", "[", "]")
    }
    infix fun intersect(other: Lotto): Set<Int> {
        val otherSet = other.numbersSet
        return numbersSet intersect otherSet
    }
    fun contains(number: Int) = numbersSet.contains(number)
}
