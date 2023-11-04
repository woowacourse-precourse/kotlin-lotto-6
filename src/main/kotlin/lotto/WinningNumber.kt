package lotto

class WinningNumber(
    private val numbers: List<Int>,
    private val bonus: Int
) {
    init {
        requireUnique(numbers, bonus)
        require(numbers.size == NUMBERS_SIZE)
        require(numbers.isInLottoNumberRange())
        require(bonus.isInLottoNumberRange())
    }

    private fun requireUnique(numbers: List<Int>, bonusNumber: Int) {
        val totalNumbers = numbers + bonusNumber
        require(totalNumbers.isUnique())
    }

    fun check(lotto: Lotto): WinningResult {
        var winningCount = 0
        numbers.forEach { number ->
            if (lotto.contains(number)) {
                ++winningCount
            }
        }
        val bonusCount = if (lotto.contains(bonus)) 1 else 0
        return WinningResult.create(
            winningCount = winningCount,
            bonusCount = bonusCount
        )
    }

    companion object {
        private const val NUMBERS_SIZE = 6
    }
}
