package lotto.domain

import lotto.Constants.LOTTO_COUNT

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_COUNT)
        require(toSet().size == LOTTO_COUNT)
    }
    private fun sorted() = numbers.sorted()
    private fun toSet() = numbers.toSet()
    override fun toString(): String {
        return sorted().joinToString(", ", "[", "]")
    }
    infix fun intersect(other: Lotto): Set<Int> {
        val otherSet = other.toSet()
        return toSet() intersect otherSet
    }
    fun contains(number: Int) = toSet().contains(number)
}
