package lotto

import lotto.model.Profit
import lotto.model.Rank
import lotto.util.Constants
import org.junit.jupiter.api.Test
import kotlin.math.round
import org.junit.jupiter.api.Assertions.assertEquals

class ProfitTest {
    @Test
    fun testCalculateProfit() {
        val jackpot = listOf(1, 0, 0, 0, 0)
        val money = 3000

        val profit = Profit().calculateProfit(money, jackpot)
        assertEquals(166.7f, profit, 0.01f)
    }
}