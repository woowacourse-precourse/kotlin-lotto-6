package lotto.domain

import lotto.util.WRONG_COUNT_EXCEPTION

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { WRONG_COUNT_EXCEPTION }
    }

    override fun toString(): String = numbers.joinToString(", ", "[", "]")
    fun intersect(winning: List<Int>): Set<Int> {
        return numbers.intersect(winning.toSet())
    }

    fun contains(bonus: Int): Boolean {
        if (numbers.contains(bonus)) return true
        return false
    }

//    fun sortNumber(): List<Int> = numbers.sorted()
}
