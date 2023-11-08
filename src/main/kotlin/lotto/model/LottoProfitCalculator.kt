package lotto.model

import lotto.model.domain.Money
import lotto.model.domain.Rank

class LottoProfitCalculator(private val money: Money, private val rankCounts: Map<Rank, Int>) {

    fun calculateProfitRate(): Double {
        val totalInvestment = money.amount.toDouble()
        val totalWinnings = calculateTotalWinnings()
        return (totalWinnings / totalInvestment) * 100
    }

    private fun calculateTotalWinnings() = rankCounts.entries.sumOf { entry -> entry.key.winningAmount * entry.value }
}