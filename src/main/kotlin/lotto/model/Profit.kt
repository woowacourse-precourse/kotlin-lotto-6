package lotto.model

data class Profit(val totalProfit: Int) {
    private var _profitRate: Double = 0.0

    val profitRate: Double
        get() = _profitRate

    fun calculateProfitRate(payment: Int): Double {
        return 0.0
    }

}