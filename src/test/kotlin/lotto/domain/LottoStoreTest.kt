package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoStoreTest {
    private lateinit var lottoStore: LottoStore
    @BeforeEach
    fun setUp() {
        lottoStore = LottoStore("5000")
    }

    @Test
    fun `getNumberOfTickets가 티켓 수를 잘 반환하는지`() {
        val numberOfTickets = lottoStore.getNumberOfTickets()
        assertEquals(5, numberOfTickets)
    }

    @Test
    fun `sellTickets가 티켓을 잘 만드는지`() {
        val tickets = lottoStore.sellTickets()
        assertEquals(5, tickets.size)
    }
}
