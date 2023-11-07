package lotto

import lotto.domain.LottoGameService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameServiceTest {
    val lottoGameService = LottoGameService()

    @Test
    fun `getQuantity returns correct quantity`() {
        val purchaseAmount = 10000
        val expectedQuantity = 10
        val actualQuantity = lottoGameService.getQuantity(purchaseAmount)
        assertEquals(expectedQuantity, actualQuantity)
    }
}