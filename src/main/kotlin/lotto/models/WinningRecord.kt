package lotto.models

class WinningRecord {
    private val _record: MutableMap<WinningRank, Int> = mutableMapOf()
    val record: Map<WinningRank, Int> get() = _record

    init {
        initializeRecord()
    }

    private fun initializeRecord() = WinningRank.entries.forEach { _record[it] = 0 }

    fun calculateMatchingNumbers(purchasedLotto: Lotto, winningLotto: Lotto): Int {
        val purchasedLottoNumbers = purchasedLotto.getNumbers()
        val winningLottoNumbers = winningLotto.getNumbers()

        return purchasedLottoNumbers.count { it in winningLottoNumbers }
    }

    fun hasMatchingBonusNumber(purchasedLotto: Lotto, bonus: Bonus): Boolean {
        val bonusNumber = bonus.getNumber()
        val purchasedLottoNumbers = purchasedLotto.getNumbers()

        return bonusNumber in purchasedLottoNumbers
    }

    fun recordWinningResults(purchasedLottos: List<Lotto>, winningLotto: Lotto, bonus: Bonus) {
        purchasedLottos.forEach { purchasedLotto ->
            val matchedCount = calculateMatchingNumbers(purchasedLotto, winningLotto)
            val hasMatchingBonus = hasMatchingBonusNumber(purchasedLotto, bonus)

            val winningRank = WinningRank.find(matchedCount, hasMatchingBonus)
            _record[winningRank] = (_record[winningRank] ?: 0) + 1
        }
    }
}