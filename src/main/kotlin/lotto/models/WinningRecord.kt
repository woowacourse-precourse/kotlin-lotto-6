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

    fun hasMatchingBonusNumber(winningLotto: Lotto, bonus: Bonus): Boolean {
        val bonusNumber = bonus.getNumber()
        val winningLottoNumbers = winningLotto.getNumbers()

        return bonusNumber in winningLottoNumbers
    }

    fun recordWinningResults(purchasedLottos: List<Lotto>, winningLotto: Lotto, bonus: Bonus) {
        _record[WinningRank.NOTHING] = (_record[WinningRank.NOTHING] ?: 0) + 1
    }
}