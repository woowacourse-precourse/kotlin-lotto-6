package lotto.model

import lotto.utils.Constants.FIFTH_PRIZE_MONEY
import lotto.utils.Constants.FIRST_PRIZE_MONEY
import lotto.utils.Constants.FOURTH_PRIZE_MONEY
import lotto.utils.Constants.HUNDRED_PERCENTAGE
import lotto.utils.Constants.INITIALIZE_DOUBLE
import lotto.utils.Constants.SECOND_PRIZE_MONEY
import lotto.utils.Constants.THIRD_PRIZE_MONEY

class Profit(private var _profit: Double = INITIALIZE_DOUBLE) {
    private fun setProfit(result: Double) {
        this._profit = result
    }

    fun getProfit(): Double = _profit

    fun calculateLottoProfit(rankCount: List<Int>, pay: Int) {
        val totalPrizeMoney = countProfit(rankCount)

        setProfit((totalPrizeMoney.toDouble() / pay) * HUNDRED_PERCENTAGE)
    }

    private fun countProfit(rankCount: List<Int>): Int {
        val prizeMoney = listOf(
            FIFTH_PRIZE_MONEY,
            FOURTH_PRIZE_MONEY,
            THIRD_PRIZE_MONEY,
            SECOND_PRIZE_MONEY,
            FIRST_PRIZE_MONEY
        )

        return rankCount.zip(prizeMoney) { count, multiplier -> count * multiplier }.sum()
    }
}