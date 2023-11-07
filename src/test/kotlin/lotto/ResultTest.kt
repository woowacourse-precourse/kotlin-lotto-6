package lotto

import lotto.Model.Prize
import lotto.Model.Result
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


class ResultTest {

    @Test
    fun testCalculateMatchingCount() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // Test a ticket that matches all numbers and the bonus number
        val allMatchingTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        var matchingCount = Result.calculateMatchingCount(allMatchingTicket, winningNumbers, bonusNumber)
        assertEquals(6, matchingCount)

        // Test a ticket that matches all numbers without the bonus number
        val noBonusMatchingTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        matchingCount = Result.calculateMatchingCount(noBonusMatchingTicket, winningNumbers, bonusNumber)
        assertEquals(6, matchingCount)

        // Test a ticket that matches only 3 numbers
        val threeMatchingTicket = Lotto(listOf(1, 2, 3, 10, 11, 12))
        matchingCount = Result.calculateMatchingCount(threeMatchingTicket, winningNumbers, bonusNumber)
        assertEquals(3, matchingCount)
    }

    @Test
    fun testCalculateResults() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val lottoTickets = List(10) {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        }

        val results = Result.calculateResults(lottoTickets, winningNumbers, bonusNumber)

        assertEquals(0, results["0"])
        assertEquals(0, results["1"])
        assertEquals(0, results["2"])
        assertEquals(0, results["3"])
        assertEquals(0, results["4"])
        assertEquals(0, results["5"])
        assertEquals(0, results["5.1"])
        assertEquals(10, results["6"])
    }

}
