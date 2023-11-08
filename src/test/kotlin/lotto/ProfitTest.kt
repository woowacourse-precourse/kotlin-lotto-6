package lotto

import domain.winningdetail.Jackpot
import domain.winningdetail.Profit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitTest {
    @Test
    fun `수익률 계산`() {
        val profit = Profit()

        val stats = mapOf(
            Jackpot.FIRST to 1,
            Jackpot.THIRD to 3,
            null to 0
        )
        val amountInvested = "10000000" // Assuming 10 million won invested

        val actualProfit = profit.getProfit(stats, amountInvested)

        val expectedTotalAmount = (2_000_000_000 * 1) + (1_500_000 * 3)
        val expectedProfit = (expectedTotalAmount / amountInvested.toDouble()) * 100
        val expectedProfitFormatted = String.format("%.1f", expectedProfit)

        assertEquals(expectedProfitFormatted, actualProfit)
    }
}