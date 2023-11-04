package lotto

class WinningNumber(
    private val numbers: List<Int>,
    private val bonus: Int
) {
    init {
        requireUnique(numbers, bonus)
    }

    private fun requireUnique(numbers: List<Int>, bonusNumber: Int) {
        val totalNumbers = numbers + bonusNumber
        require(totalNumbers.isUnique())
    }
}
