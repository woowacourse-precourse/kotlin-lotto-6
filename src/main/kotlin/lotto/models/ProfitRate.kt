package lotto.models

import kotlin.math.roundToInt

class ProfitRate {
    private var value: Double = 0.0

    fun get() = value

    fun calculate(purchase: Purchase, winningRecord: WinningRecord): Double {
        val purchaseAmount = purchase.getAmount()
        val totalWinningAmount = sumTotalWinningAmount(winningRecord)
        val rate = ((totalWinningAmount.toDouble() - purchaseAmount) / purchaseAmount) * 100

        return 100 + rate.roundTo2DecimalPlaces()
    }

    internal fun sumTotalWinningAmount(winningRecord: WinningRecord): Int {
        return winningRecord.value.entries.sumOf {
            (winning, count) -> winning.amount * count
        }
    }
}

fun Double.roundTo2DecimalPlaces(): Double {
    return (this * 100.0).roundToInt() / 100.0
}