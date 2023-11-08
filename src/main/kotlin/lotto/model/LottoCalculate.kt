package lotto.model

import lotto.util.LottoView

class LottoCalculate {
    fun formattedCheck(profit: Double) : String {
        return String.format("%.1f", profit)
    }

    fun lottoProfit(invest: Int,totalResult: List<Int>) {
        var profit = 0.0
        profit += totalResult[0] * 2000000000
        profit += totalResult[1] * 30000000
        profit += totalResult[2] * 1500000
        profit += totalResult[3] * 50000
        profit += totalResult[4] * 5000
        val profitMargin = profit / invest * 100
        val formattedProfit = formattedCheck(profitMargin)
        LottoView().totalRate(formattedProfit)
    }
}