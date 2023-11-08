package lotto

import lotto.enums.LottoResult

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    override fun toString(): String {
        val sortedNumbers = numbers.sorted()
        return sortedNumbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }

    fun calculateLottoResult(winningNumbers: List<Int>, bonusNumber: Int): LottoResult {
        val sameNumberCount = numbers.intersect(winningNumbers.toSet()).size
        val differentNumbers = numbers.subtract(winningNumbers.toSet())
        return when {
            sameNumberCount == 3 -> LottoResult.FIFTH
            sameNumberCount == 4 -> LottoResult.FOURTH
            sameNumberCount == 5 && differentNumbers.first() == bonusNumber -> LottoResult.SECOND
            sameNumberCount == 5 -> LottoResult.THIRD
            sameNumberCount == 6 -> LottoResult.FIRST
            else -> LottoResult.NOTHING
        }
    }
}
