package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return numbers.joinToString(", ", "[", "]")
    }

    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { winningNumbers.contains(it) }
    }

    fun hasBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
