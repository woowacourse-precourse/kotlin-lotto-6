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

    fun rankManager(answerLottoNumbers: List<Int>, lotto: Lotto, bonusNumber: Int): MutableMap<Prize, Int> {
        val userWinningNumbers = lotto.getLotto()
        val bonusMatch = lottoRank.bonusMatched(bonusNumber, answerLottoNumbers)
        val matchedNumbers = lottoRank.checkMatchingNumbers(answerLottoNumbers, userWinningNumbers)
        winningResultsUpdate(matchedNumbers, results, bonusMatch)

        return results
    }

    private fun winningResultsUpdate(matchedNumbers: Int, results: MutableMap<Prize, Int>, bonusMatch: Boolean) {
        when (matchedNumbers) {
            Constants.THREE -> results[Prize.THREE_MATCH] = results.getOrDefault(Prize.THREE_MATCH, 0) + 1
            Constants.FOUR -> results[Prize.FOUR_MATCH] = results.getOrDefault(Prize.FOUR_MATCH, 0) + 1
            Constants.FIVE -> {
                if (bonusMatch) {
                    results[Prize.FIVE_MATCH_WITH_BONUS] = results.getOrDefault(Prize.FIVE_MATCH_WITH_BONUS, 0) + 1
                }
                results[Prize.FIVE_MATCH] = results.getOrDefault(Prize.FIVE_MATCH, 0) + 1
            }
            Constants.SIX -> results[Prize.SIX_MATCH] = results.getOrDefault(Prize.SIX_MATCH, 0) + 1
        }
    }
}