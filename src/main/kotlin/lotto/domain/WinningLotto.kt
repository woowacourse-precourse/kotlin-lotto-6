package lotto.domain

class WinningLotto(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int,
) {
    fun calculateMatchingCount(lotto: Lotto): Int {
        return winningNumbers.getNumbers().count { lotto.hasNumber(it) }
    }

    fun calculateBonusMatch(lotto: Lotto): Boolean {
        return lotto.hasNumber(bonusNumber)
    }
}