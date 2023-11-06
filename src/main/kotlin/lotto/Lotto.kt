package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }
}