package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoNumberDispenserTest {

    @Test
    fun `buyTickets 메소드가 금액에 알맞은 수량의 로또를 반환하는지 테스트`() {
        val dispenser = LottoNumberDispenser()
        val money = 10_000
        val expectedTicketQuantity = 10
        val expectedLottoNumberSize = 6

        val lottoTickets = dispenser.buyTickets(money)
        val actualTicketQuantity = lottoTickets.size

        assertEquals(expectedTicketQuantity, actualTicketQuantity)
        lottoTickets.forEach { lotto ->
            assertEquals(expectedLottoNumberSize, lotto.toAscendingNumbers().size)
        }
    }
}