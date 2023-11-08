package lotto

import lotto.model.LottoProfit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoProfitTest {
    private val lottoProfit = LottoProfit()

    @Test
    fun `총합 계산 테스트`(){
        val rank = listOf(0, 0, 0, 0, 1)

        val totalReward = lottoProfit.calculateTotal(rank)
        assertEquals(5000.0, totalReward)
    }
    @Test
    fun `수익률 계산 테스트`() {
        val totalReward = 5000.0
        val amount = 8000

        val profit = lottoProfit.calculateProfit(totalReward, amount)

        assertEquals(62.5, profit)
    }
}