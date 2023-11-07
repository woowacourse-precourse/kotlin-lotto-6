package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_ERROR }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { SAME_NUMBER_ERROR }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { NUMBER_RANG_ERROR }
    }

    override fun toString(): String = numbers.joinToString(", ", "[", "]")

    fun countMatchingNumbers(winningNumbers: List<Int>): Int = numbers.count { winningNumbers.contains(it) }

    fun hasBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)

    companion object {
        const val LOTTO_NUMBER_ERROR = "로또에는 6개의 숫자가 입력되어야 합니다."
        const val SAME_NUMBER_ERROR = "중복된 숫자가 있으면 안됩니다."
        const val NUMBER_RANG_ERROR = "1과 45 사이의 숫자가 입력되어야 합니다."
        const val LOTTO_NUMBER_COUNT = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
