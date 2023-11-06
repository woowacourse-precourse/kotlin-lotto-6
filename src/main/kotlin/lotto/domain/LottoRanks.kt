package lotto.domain

import lotto.Lotto

enum class Prize(val matchingNumbers: Int, val prizeAmount: Int) {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000)
}

class LottoRanks {

    val results = mutableMapOf<Prize, Int>()
    init {
        Prize.entries.forEach { results[it] = 0 }
    }
    fun rank(lottoList: List<Int>, lotto: Lotto, bonusNumber: Int): MutableMap<Prize, Int> {
        val winningNumbers = lottoList
        val userNumbers = lotto.getLotto()
        val bonusMatch =  bonusMatched(bonusNumber, winningNumbers)
        val matchedNumbers = checkMatchingNumbers(winningNumbers, userNumbers)
        winningResultsUpdate(matchedNumbers, results, bonusMatch)


        return results
    }

    private fun checkMatchingNumbers(winningNumbers: List<Int>, userNumbers: List<Int>): Int{
        var matchedNumbers = 0
        userNumbers.forEach {
            if (it in winningNumbers) {
                matchedNumbers++
            }
        }
        return matchedNumbers
    }

    private fun bonusMatched(bonusNumber: Int, winningNumbers: List<Int>): Boolean {
        return winningNumbers.contains(bonusNumber)
    }
    private fun winningResultsUpdate(matchedNumbers: Int, results: MutableMap<Prize, Int>, bonusMatch: Boolean) {
        when (matchedNumbers) {
            3 -> results[Prize.THREE_MATCH] = results.getOrDefault(Prize.THREE_MATCH, 0) + 1
            4 -> results[Prize.FOUR_MATCH] = results.getOrDefault(Prize.FOUR_MATCH, 0) + 1
            5 -> {
                if (bonusMatch) {
                    results[Prize.FIVE_MATCH_WITH_BONUS] = results.getOrDefault(Prize.FIVE_MATCH_WITH_BONUS, 0) + 1
                } else {
                    results[Prize.FIVE_MATCH] = results.getOrDefault(Prize.FIVE_MATCH, 0) + 1
                }
            }

            6 -> results[Prize.SIX_MATCH] = results.getOrDefault(Prize.SIX_MATCH, 0) + 1
        }
    }
}
