package lotto

import lotto.model.Profit
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProfitTest {
    private lateinit var profit: Profit

    @BeforeEach
    fun setUp() {
        profit = Profit()
    }

    @Test
    fun `수익률을 정확하게 계산한다`() {
        profit.calculateLottoProfit(listOf(1, 0, 0, 0, 0), 5000)

        Assertions.assertTrue(profit.getProfit() == 100.0)
    }
}