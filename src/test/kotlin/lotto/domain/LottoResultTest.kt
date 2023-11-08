package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `수익률 정상 계산`() {
        val lottoResult = LottoResult()
        val results = listOf(LottoRank.THIRD, LottoRank.FOURTH)
        val purchasePrice = 5000

        val rateOfReturn = lottoResult.calculateRateOfReturn(results, purchasePrice)

        val expectedRateOfReturn = ((1500000.0 + 50000.0) / purchasePrice) * 100
        assertEquals(expectedRateOfReturn, rateOfReturn)
    }
}
