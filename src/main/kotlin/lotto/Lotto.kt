package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return getSortedNumbers().intersect(winningNumbers).size
    }
}