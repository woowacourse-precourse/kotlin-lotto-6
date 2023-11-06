package lotto.domain

class LottoYield {
    fun calcurateLottoYield(matchResult: Map<Prize, Int>, amount: Int): Double {
        val income = calculateTotalProfit(matchResult)
        return (income / amount.toDouble() * 100)
    }

    private fun calculateTotalProfit(results: Map<Prize, Int>): Long {
        var profit = 0L

        results.entries.forEach { (prize, count) ->
            profit += (prize.prizeAmount * count)
        }
        return profit
    }
}

