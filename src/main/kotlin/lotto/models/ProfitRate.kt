package lotto.models

class ProfitRate {
    private var value: Double = 0.0

    fun get() = value

    fun calculate(purchaseAmount: Purchase, winningRecord: WinningRecord): Double {

        return 100.0
    }

    internal fun sumTotalWinningAmount(winningRecord: WinningRecord): Int {
        return winningRecord.value.entries.sumOf {
            (winning, count) -> winning.amount * count
        }
    }
}