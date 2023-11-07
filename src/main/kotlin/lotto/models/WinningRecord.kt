package lotto.models

class WinningRecord {

    fun calculateMatchingNumbers(purchasedLotto: Lotto, winningLotto: Lotto): Int {
        val purchasedLottoNumbers = purchasedLotto.getNumbers()
        val winningLottoNumbers = winningLotto.getNumbers()

        return purchasedLottoNumbers.count { it in winningLottoNumbers }
    }

    fun hasMatchingBonusNumber(winningLotto: Lotto, bonus: Bonus): Boolean {
        return false
    }
}