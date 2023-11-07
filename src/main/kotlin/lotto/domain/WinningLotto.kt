package lotto.domain

class WinningLotto(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int,
) {
    fun checkCountMatched(lotto: Lotto): Int {
        return winningNumbers.getNumbers().count { number ->
            lotto.hasNumber(number)
        }
    }

    fun checkBonusMatch(lotto: Lotto): Boolean {
        return lotto.hasNumber(bonusNumber)
    }
}