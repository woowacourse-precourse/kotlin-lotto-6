package lotto.model

class LottoWinningNumbers(
    val winningNumbers: List<Int>,
    val bonusNumber: Int
) {
    init {
        require(winningNumbers.size == 6)
        require(hasNumberDuplicates())
    }

    private fun hasNumberDuplicates(): Boolean {
        val allNumbers = winningNumbers.toMutableSet()
        allNumbers.add(bonusNumber)

        if (winningNumbers.size + 1 != allNumbers.size) {
            return false
        }
        return true
    }

}