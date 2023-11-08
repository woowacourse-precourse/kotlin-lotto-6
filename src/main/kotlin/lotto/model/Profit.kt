package lotto.model

import kotlin.math.round

data class Profit(val totalProfit: Int) {
    private var profitRate = 0.0

    fun calculateProfitRate(payment: Int): Double {
        profitRate = totalProfit.toDouble() / payment.toDouble() * 100.0
        profitRate = round(profitRate * 10) / 10
        return profitRate
    }
}