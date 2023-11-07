package lotto

import lotto.model.LottoTicketCount
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoCountTest {
    private val purchase = "10000"
    private val lottoTicketCount = LottoTicketCount(purchase)

    @Test
    @DisplayName("구입 금액으로 로또 수량을 구함")
    fun lottoTicketCountTest(){
        val expected = 10
        val actualValue = lottoTicketCount.lottoCount
        assertEquals(expected,actualValue)
    }

}