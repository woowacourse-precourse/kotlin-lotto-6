package lotto.domain

import lotto.model.Lotto
import lotto.model.Prize
import lotto.utils.Constants.FIVE
import lotto.utils.Constants.FOUR
import lotto.utils.Constants.INIT_ZERO
import lotto.utils.Constants.SIX
import lotto.utils.Constants.THREE

class LottoRanks {
    private val results = mutableMapOf<Prize, Int>()

    init {
        Prize.entries.forEach { results[it] = INIT_ZERO }
    }

    fun rank(answerLottoNumbers: List<Int>, lotto: Lotto, bonusNumber: Int): MutableMap<Prize, Int> {
        val userWinningNumbers = lotto.getLotto()
        val bonusMatch = bonusMatched(bonusNumber, answerLottoNumbers)
        val matchedNumbers = checkMatchingNumbers(answerLottoNumbers, userWinningNumbers)
        winningResultsUpdate(matchedNumbers, results, bonusMatch)

        return results
    }

    private fun checkMatchingNumbers(answerLottoNumbers: List<Int>, userWinningNumbers: List<Int>): Int {
        var matchedNumbers = INIT_ZERO
        userWinningNumbers.forEach {
            if (it in answerLottoNumbers) {
                matchedNumbers++
            }
        }
        return matchedNumbers
    }

    private fun bonusMatched(bonusNumber: Int, answerLottoNumbers: List<Int>): Boolean {
        return answerLottoNumbers.contains(bonusNumber)
    }

    private fun winningResultsUpdate(matchedNumbers: Int, results: MutableMap<Prize, Int>, bonusMatch: Boolean) {
        when (matchedNumbers) {
            THREE -> results[Prize.THREE_MATCH] = results.getOrDefault(Prize.THREE_MATCH, 0) + 1
            FOUR -> results[Prize.FOUR_MATCH] = results.getOrDefault(Prize.FOUR_MATCH, 0) + 1
            FIVE -> {
                if (bonusMatch) {
                    results[Prize.FIVE_MATCH_WITH_BONUS] = results.getOrDefault(Prize.FIVE_MATCH_WITH_BONUS, 0) + 1
                }
                results[Prize.FIVE_MATCH] = results.getOrDefault(Prize.FIVE_MATCH, 0) + 1
            }

            SIX -> results[Prize.SIX_MATCH] = results.getOrDefault(Prize.SIX_MATCH, 0) + 1
        }
    }
}