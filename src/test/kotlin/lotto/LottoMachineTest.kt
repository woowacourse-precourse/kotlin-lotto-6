package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `금액에 따른 로또 티켓 개수`() {
        // Given
        val money = 5000

        // When
        val tickets = LottoMachine.buyTickets(money)

        // Then
        assertEquals(5, tickets.size)
    }

}
