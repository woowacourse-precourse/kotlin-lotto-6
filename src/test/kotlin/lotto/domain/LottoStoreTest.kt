package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoStoreTest {
    @Test
    fun `getNumberOfTickets가 티켓 수를 잘 반환하는지`() {
        val lottoStore = LottoStore("5000")
        val numberOfTickets = lottoStore.getNumberOfTickets()
        assertEquals(5, numberOfTickets)
    }

    @Test
    fun `sellTickets가 티켓을 잘 만드는지`() {
        val lottoStore = LottoStore("5000")
        val tickets = lottoStore.sellTickets()

        assertEquals(5, tickets.size)
    }
}
