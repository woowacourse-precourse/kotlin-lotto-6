package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "Numbers must contain exactly 6 integers." }
        require(numbers.all { it in 1..45 }) {
            "All numbers must be between 1 and 45."
        }
    }

    fun getNumbers(): List<Int> = numbers

    fun checkMatch(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers.toSet()).size
    }

    fun hasBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]")
    }

    companion object {
        fun generateNumbers(): List<Int> {
            return (1..45).shuffled().take(6).sorted()
        }
    }
}