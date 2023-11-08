package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    fun checkWinningNumbers(winningNumbers: List<Int>, bonusNumber: Int): WinningResult {
        val matchCount = numbers.count { it in winningNumbers }
        val hasBonusNumber = bonusNumber in numbers
        return when (matchCount) {
            3 -> if (hasBonusNumber) WinningResult.FIVE_WITH_BONUS else WinningResult.THREE
            4 -> WinningResult.FOUR
            5 -> if (hasBonusNumber) WinningResult.FIVE_WITH_BONUS else WinningResult.FIVE
            6 -> WinningResult.SIX
            else -> WinningResult.NONE
        }
    }

    override fun toString(): String {
        return numbers.sorted().joinToString(", ", "[", "]")
    }
}
