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

    @Test
    fun testCalculateProfitRate() {
        val results = mapOf("0" to 10, "1" to 20, "2" to 30, "3" to 40, "4" to 50, "5" to 60, "5.1" to 70, "6" to 80)
        val profitRate = Result.calculateProfitRate(results)

        val totalPrize = Result.calculateTotalPrize(results)
        val totalPurchaseAmount = Result.calculateTotalPurchaseAmount(results)

        val expectedProfitRate = (totalPrize / totalPurchaseAmount) * 100
        assertEquals(expectedProfitRate, profitRate)
    }

    @Test
    fun testCalculateTotalPrize() {
        val results = mapOf("0" to 10, "1" to 20, "2" to 30, "3" to 40, "4" to 50, "5" to 60, "5.1" to 70, "6" to 80)

        val totalPrize = Result.calculateTotalPrize(results)

        val expectedTotalPrize = results.entries.sumByDouble { entry ->
            val prize = Prize.getPrize(entry.key)
            val prizeWithoutCommas = prize.replace(",", "").toDouble()
            entry.value * prizeWithoutCommas
        }

        assertEquals(expectedTotalPrize, totalPrize)
    }

    @Test
    fun testCalculateTotalPurchaseAmount() {
        val results = mapOf("0" to 10, "1" to 20, "2" to 30, "3" to 40, "4" to 50, "5" to 60, "5.1" to 70, "6" to 80)

        val totalPurchaseAmount = Result.calculateTotalPurchaseAmount(results)

        val expectedTotalPurchaseAmount = results.values.sum() * 1000

        assertEquals(expectedTotalPurchaseAmount, totalPurchaseAmount)
    }
}
