package lotto

import domain.LottoRateOfReturn
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRateOfReturnTest {
    @Test
    fun `총 당첨 금액을 확인`() {
        val winningAmount = LottoRateOfReturn(
            checkPrize = prizeResult,
            amount = AMOUNT
        ).getTotalPrize()
        assertEquals(winningAmount, 55000)
    }

    @Test
    fun `수익률 확인`() {
        val rateOfReturn = LottoRateOfReturn(
            checkPrize = prizeResult,
            amount = AMOUNT
        ).rateOfReturn()
        assertEquals(rateOfReturn, "687.5%")
    }

    companion object {
        private val prizeResult = arrayOf(1, 1, 0, 0, 0)
        private const val AMOUNT = 8000
    }
}