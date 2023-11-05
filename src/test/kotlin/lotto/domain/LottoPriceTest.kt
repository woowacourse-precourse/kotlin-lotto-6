package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoPriceTest {
    @Test
    fun `티켓 수 반환 테스트`() {
        val lottoPrice = LottoPrice("5000")
        val numberOfTickets = lottoPrice.getNumberOfTickets()
        assertEquals(5, numberOfTickets)
    }
}
