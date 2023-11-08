package lotto.model

import lotto.util.LottoView

enum class PrizeMoney(val prizeAmount: Int){
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000)
}

class LottoCalculate {
    fun formattedCheck(profit: Double) : String {
        return String.format("%.1f", profit)
    }

    fun lottoProfit(invest: Int, totalResult: List<Int>) {
        var profit = 0.0
        profit += totalResult[0] * PrizeMoney.FIRST_PRIZE.prizeAmount
        profit += totalResult[1] * PrizeMoney.SECOND_PRIZE.prizeAmount
        profit += totalResult[2] * PrizeMoney.THIRD_PRIZE.prizeAmount
        profit += totalResult[3] * PrizeMoney.FOURTH_PRIZE.prizeAmount
        profit += totalResult[4] * PrizeMoney.FIFTH_PRIZE.prizeAmount
        val profitMargin = profit / invest * 100
        val formattedProfit = formattedCheck(profitMargin)
        LottoView().totalRate(formattedProfit)
    }
}