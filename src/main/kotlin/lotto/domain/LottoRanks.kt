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
        val winningNumbers = lottoList // 예시로 고정된 당첨 번호
        val bonusNumber = bonusNumber // 예시로 고정된 보너스 번호
        val userNumbers = lotto.getLotto() // 예시로 고정된 참가자 번호

        val matchedNumbers = checkMatchingNumbers(winningNumbers, userNumbers)
        winningResultsUpdate(matchedNumbers, results)


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

    private fun winningResultsUpdate(matchedNumbers: Int, results: MutableMap<Prize, Int>) {
        when (matchedNumbers) {
            3 -> results[Prize.THREE_MATCH] = results.getOrDefault(Prize.THREE_MATCH, 0) + 1
            4 -> results[Prize.FOUR_MATCH] = results.getOrDefault(Prize.FOUR_MATCH, 0) + 1
            5 -> results[Prize.FIVE_MATCH] = results.getOrDefault(Prize.FIVE_MATCH, 0) + 1
            6 -> results[Prize.SIX_MATCH] = results.getOrDefault(Prize.SIX_MATCH, 0) + 1
        }
    }

}
