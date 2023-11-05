package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == numbers.size)
    }

    override fun toString(): String = numbers.toString()

    fun countSameNumber(winningNumbers: List<Int>): Int = numbers.count { it in winningNumbers }

    fun hasBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)
}
