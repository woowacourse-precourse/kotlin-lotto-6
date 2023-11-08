package lotto.models

class WinningRecord {
    private val _value: MutableMap<WinningRank, Int> = mutableMapOf()
    val value: Map<WinningRank, Int> get() = _value

    init {
        initializeRecord()
    }

    private fun initializeRecord() = WinningRank.getAll().forEach { _value[it] = 0 }

    fun updateWinningResults(purchasedLottos: List<Lotto>, winningLotto: Lotto, bonus: Bonus) {
        purchasedLottos.forEach { purchasedLotto ->
            val matchedCount = calculateMatchingNumbers(purchasedLotto, winningLotto)
            val hasMatchingBonus = hasMatchingBonusNumber(purchasedLotto, bonus)
            val winningRank = WinningRank.find(matchedCount, hasMatchingBonus)

            updateRecord(winningRank)
        }
    }

    internal fun calculateMatchingNumbers(purchasedLotto: Lotto, winningLotto: Lotto): Int {
        val purchasedLottoNumbers = purchasedLotto.getNumbers()
        val winningLottoNumbers = winningLotto.getNumbers()

        return purchasedLottoNumbers.count { it in winningLottoNumbers }
    }

    internal fun hasMatchingBonusNumber(purchasedLotto: Lotto, bonus: Bonus): Boolean {
        val bonusNumber = bonus.getNumber()
        val purchasedLottoNumbers = purchasedLotto.getNumbers()

        return bonusNumber in purchasedLottoNumbers
    }

    private fun updateRecord(winningRank: WinningRank) {
        _value[winningRank] = (_value[winningRank] ?: 0) + 1
    }
}