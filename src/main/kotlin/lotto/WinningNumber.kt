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

    companion object {
        private const val NUMBERS_SIZE = 6
    }
}
