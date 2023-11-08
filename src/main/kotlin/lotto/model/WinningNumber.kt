package lotto.model

class WinningNumber(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    fun getWinningNumbers() = winningNumbers

    fun getBonusNumber() = bonusNumber
}