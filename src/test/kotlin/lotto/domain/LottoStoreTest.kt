package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoStoreTest {
    @Test
    fun `티켓 수 반환 테스트`() {
        val lottoStore = LottoStore("5000")
        val numberOfTickets = lottoStore.getNumberOfTickets()
        assertEquals(5, numberOfTickets)
    }
}
