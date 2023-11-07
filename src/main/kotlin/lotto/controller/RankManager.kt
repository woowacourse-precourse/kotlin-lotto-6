package lotto.controller

import lotto.domain.LottoRanks
import lotto.model.Lotto
import lotto.model.Prize
import lotto.utils.Constants

class RankManager() {
    private val lottoRank = LottoRanks()
    private val results = mutableMapOf<Prize, Int>()
    init {
        Prize.entries.forEach { results[it] = Constants.INIT_ZERO }
    }

    fun rankManager(lotto: Lotto, answerLottoNumbers: List<Int>, bonusNumber: Int): MutableMap<Prize, Int> {
        val userWinningNumbers = lotto.getLotto()
        val bonusMatch = lottoRank.bonusMatched(bonusNumber, answerLottoNumbers)
        val matchedNumbers = lottoRank.checkMatchingNumbers(answerLottoNumbers, userWinningNumbers)
        winningResultsUpdate(matchedNumbers, results, bonusMatch)

        return results
    }

    private fun winningResultsUpdate(matchedNumbers: Int, results: MutableMap<Prize, Int>, bonusMatch: Boolean) {
        when (matchedNumbers) {
            Constants.THREE -> results.compute(Prize.THREE_MATCH) { _, value -> (value ?: 0) + 1 }
            Constants.FOUR -> results.compute(Prize.FOUR_MATCH) { _, value -> (value ?: 0) + 1 }
            Constants.FIVE -> {
                if (bonusMatch) {
                    results.compute(Prize.FIVE_MATCH_WITH_BONUS) { _, value -> (value ?: 0) + 1 }
                }
                if (!bonusMatch) {
                    results.compute(Prize.FIVE_MATCH) { _, value -> (value ?: 0) + 1 }
                }
            }
            Constants.SIX -> results.compute(Prize.SIX_MATCH) { _, value -> (value ?: 0) + 1 }
        }
    }
}