package lotto.models

import lotto.utils.Extensions.roundTo2DecimalPlaces

class ProfitRate {
    private var _value: Double = 0.0
    val value get() = _value


    fun calculate(purchase: Purchase, winningRecord: WinningRecord) {
        val purchaseAmount = purchase.getAmount()
        val totalWinningAmount = sumTotalWinningAmount(winningRecord)
        val rate = ((totalWinningAmount.toDouble() - purchaseAmount) / purchaseAmount) * 100

        _value = 100 + rate.roundTo2DecimalPlaces()
    }

    internal fun sumTotalWinningAmount(winningRecord: WinningRecord): Int {
        return winningRecord.value.entries.sumOf {
            (winning, count) -> winning.amount * count
        }
    }
}