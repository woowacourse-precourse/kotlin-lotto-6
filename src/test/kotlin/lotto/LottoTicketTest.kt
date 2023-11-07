package lotto

import lotto.Model.LottoTicket
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class LottoTicketTest {

    @Test
    fun testGenerateSingleLottoTicket() {
        val lotto = LottoTicket.generateSingleLottoTicket()
        val numbers = lotto.getNumbers()
        // Test if the Lotto has exactly 6 unique numbers
        assertEquals(6, numbers.size)
        val uniqueNumbers = numbers.toSet()
        assertEquals(6, uniqueNumbers.size)

        // Test if the numbers are within the valid range (1 to 45)
        for (number in numbers) {
            assertTrue(number in 1..45)
        }
    }

    @Test
    fun testGenerateLottoTickets() {
        val purchaseAmount = 5000
        val lottoTickets = LottoTicket.generateLottoTickets(purchaseAmount)

        // Test if the number of Lotto tickets generated matches the purchase amount
        assertEquals(purchaseAmount / 1000, lottoTickets.size)

        // Test each Lotto ticket generated
        for (lotto in lottoTickets) {
            val numbers = lotto.getNumbers()

            // Test if the Lotto has exactly 6 unique numbers
            assertEquals(6, numbers.size)
            val uniqueNumbers = numbers.toSet()
            assertEquals(6, uniqueNumbers.size)

            // Test if the numbers are within the valid range (1 to 45)
            for (number in numbers) {
                assertTrue(number in 1..45)
            }
        }
    }
}
