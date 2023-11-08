package lotto.domain

import lotto.Lotto

class CheckLottoNumber(
    private val buyLottos: List<Lotto>,
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {
    private val winningCount = mutableMapOf<Stats, Int>()

    init {
        for (stats in Stats.entries)
            winningCount[stats] = LOTTO_MATCH_COUNT_MIN
    }

    fun checkLottoNumberMatchedCount(): Map<Stats, Int> {
        var bonus = false
        for (lotto in buyLottos) {
            val matchNumbersCount = getMatchNumberCount(lotto)
            if (checkBonusNumberMatched(matchNumbersCount))
                bonus = checkBonusNumberMatch(lotto)

            saveWinningCount(matchNumbersCount, bonus)
        }
        return winningCount
    }

    private fun checkBonusNumberMatched(matchNumbersCount: Int): Boolean =
        matchNumbersCount == LOTTO_MATCH_COUNT_FIVE

    private fun saveWinningCount(matchNumbersCount: Int, bonus: Boolean) {
        val stat = checkStat(matchNumbersCount, bonus)
        winningCount[stat] =
            winningCount.getOrDefault(stat, LOTTO_WINNING_COUNT_DEFAULT_VALUE) + LOTTO_WINNING_COUNT_ADD_ONE
    }

    private fun checkBonusNumberMatch(lotto: Lotto): Boolean = lotto.getLottoNumbers().contains(bonusNumber)

    companion object {
        const val LOTTO_MATCH_COUNT_MIN = 0
        const val LOTTO_MATCH_COUNT_FIVE = 5
        const val LOTTO_WINNING_COUNT_DEFAULT_VALUE = 0
        const val LOTTO_WINNING_COUNT_ADD_ONE = 1
        const val MATCHED_BONUS_NUMBER = 1
        const val NOT_MATCHED_BONUS_NUMBER = 0
    }

}