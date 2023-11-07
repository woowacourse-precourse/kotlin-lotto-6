package lotto.domain

import lotto.Lotto

class CheckLottoNumber(val buyLottos: List<Lotto>, val winningNumbers: Lotto, val bonusNumber: Int) {
    val winningCount = mutableMapOf<Stats, Int>()

    init {
        for (stats in Stats.entries)
            winningCount[stats] = LOTTO_MATCH_COUNT_MIN
    }

    fun checkLottoNumber() : Map<Stats, Int> {
        var bonus = false
        for (lotto in buyLottos) {
            val unionLotto = lotto.getLottoNumbers() + winningNumbers.getLottoNumbers()
            val matchNumbersCount = unionLotto.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct().size
            if (matchNumbersCount == 5) {
                bonus = checkBonusNumberMatch(lotto)
            }

            val stat = checkRank(matchNumbersCount, bonus)
            winningCount[stat] = winningCount.getOrDefault(stat, 0) + 1
        }
        return winningCount
    }

    fun checkBonusNumberMatch(lotto: Lotto): Boolean {
        return lotto.getLottoNumbers().contains(bonusNumber)
    }

    companion object {
        const val LOTTO_MATCH_COUNT_MIN = 0
    }

}