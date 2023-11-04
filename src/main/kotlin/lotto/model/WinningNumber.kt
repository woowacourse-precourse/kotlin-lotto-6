package lotto.model

class WinningNumber(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    fun getWinningNumbers() = winningNumbers

    fun getBonusNumber() = bonusNumber
}