package lotto.domain

class WinningLotto(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {
    fun getWinningNumbers() = winningNumbers.getNumbers()
    fun getBonusNumber() = bonusNumber
}