package lotto.models

class ProfitRate {
    private var value: Double = 0.0

    fun get() = value

    fun calculate(purchaseAmount: Int, winningRecord: Map<WinningRank, Int>): Double {

        return 100.0
    }

    internal fun sumTotalWinningAmount(winningRecord: WinningRecord): Double {
        return 300.0
    }
}