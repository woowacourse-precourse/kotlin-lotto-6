package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_ERROR }
    }

    override fun toString(): String = numbers.joinToString(", ", "[", "]")

    fun countMatchingNumbers(winningNumbers: List<Int>): Int = numbers.count { winningNumbers.contains(it) }

    fun hasBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)

    companion object {
        const val LOTTO_NUMBER_ERROR = "로또에는 6개의 숫자가 입력되어야 합니다."
        const val LOTTO_NUMBER_COUNT = 6
    }
}
