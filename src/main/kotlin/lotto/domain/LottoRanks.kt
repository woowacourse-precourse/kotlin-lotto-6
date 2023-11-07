package lotto.domain

import lotto.Lotto

enum class Prize(val matchingNumbers: Int, val prizeAmount: Int, val message: String) {
    THREE(3, 5_000, "3개 일치"),
    FOUR(4, 50_000, "4개 일치"),
    FIVE(5, 1_500_000, "5개 일치"),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2_000_000_000, "6개 일치")
}

class LottoRanks {
    private val results = mutableMapOf<Prize, Int>()
    init {
        Prize.entries.forEach { results[it] = 0 }
    }
    fun rank(answerLottoNumbers: List<Int>, lotto: Lotto, bonusNumber: Int): MutableMap<Prize, Int> {
        val userWinningNumbers = lotto.getLotto()
        val bonusMatch = bonusMatched(bonusNumber, answerLottoNumbers)
        val matchedNumbers = checkMatchingNumbers(answerLottoNumbers, userWinningNumbers)
        winningResultsUpdate(matchedNumbers, results, bonusMatch)

        return results
    }

    private fun checkMatchingNumbers(answerLottoNumbers: List<Int>, userWinningNumbers: List<Int>): Int{
        var matchedNumbers = 0
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
            Prize.THREE.matchingNumbers -> results[Prize.THREE] = results.getOrDefault(Prize.THREE, 0) + 1
            Prize.FOUR.matchingNumbers -> results[Prize.FOUR] = results.getOrDefault(Prize.FOUR, 0) + 1
            Prize.FIVE.matchingNumbers -> {
                if (bonusMatch) {
                    results[Prize.FIVE_MATCH_WITH_BONUS] = results.getOrDefault(Prize.FIVE_MATCH_WITH_BONUS, 0) + 1
                }
                results[Prize.FIVE] = results.getOrDefault(Prize.FIVE, 0) + 1
                }
            Prize.SIX.matchingNumbers -> results[Prize.SIX] = results.getOrDefault(Prize.SIX, 0) + 1
            }
        }
    }