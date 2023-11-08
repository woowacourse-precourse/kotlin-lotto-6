package lotto.model

import kotlin.math.round

data class Profit(val totalProfit: Int) {
    private var _profitRate: Double = 0.0

    val profitRate: Double
        get() = _profitRate

    fun calculateProfitRate(payment: Int): Double {
        _profitRate = totalProfit.toDouble() / payment.toDouble() * 100.0
        _profitRate = round(_profitRate * 10) / 10
        return _profitRate
    }
}