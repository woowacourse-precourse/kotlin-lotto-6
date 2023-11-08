package lotto.models

import lotto.roundTo2DecimalPlaces

class ProfitRate {
    private var value: Double = 0.0

    fun get() = value

    fun calculate(purchaseAmount: Int, winningRecord: Map<WinningRank, Int>): Double {

        return 100.0
    }
}