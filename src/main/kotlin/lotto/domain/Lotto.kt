package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun matchCount(winNumbers: List<Int>): Int {
        return numbers.intersect(winNumbers.toSet()).size
    }

    fun matchBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
