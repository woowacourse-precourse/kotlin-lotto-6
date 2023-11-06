package lotto.domain

class WinningLotto(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int,
) {
    fun checkCountMatched(lotto: Lotto): Int {
        return winningNumbers.getNumbers().count { lotto.hasNumber(it) }
    }

    fun checkBonusMatch(lotto: Lotto): Boolean {
        return lotto.hasNumber(bonusNumber)
    }
}