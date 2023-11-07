package lotto.domain

import lotto.utils.Constants.PERCENTAGE_NUMBER

class LottoYield {
    fun calculateLottoYield(matchResult: Map<Prize, Int>, amount: Int): Double {
        val income = calculateTotalProfit(matchResult)
        return (income / amount.toDouble() * PERCENTAGE_NUMBER)
    }

    private fun calculateTotalProfit(results: Map<Prize, Int>): Long {
        var profit = 0L

        results.entries.forEach { (prize, count) ->
            profit += (prize.prizeAmount * count)
        }
        return profit
    }
}

