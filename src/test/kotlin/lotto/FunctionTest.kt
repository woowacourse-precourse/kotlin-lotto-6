package lotto

import lotto.model.Jackpot
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FunctionTest {

    @Test
    fun testDiscriminate() {
        val answers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7
        val lotto = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12),
            listOf(1, 2, 3, 4, 5, 7)
        )
        val result = Jackpot().discriminate(answers, bonus, lotto)
        val expectedRank = listOf(0, 0, 0, 1, 1)
        Assertions.assertEquals(expectedRank, result)
    }

    @Test
    fun testRankUpdate() {
        val initialRank = mutableListOf(0, 0, 0, 0, 0)

        val rank4 = Jackpot().rankUpdate(5, initialRank, false)
        Assertions.assertIterableEquals(listOf(0, 0, 1, 0, 0), rank4)

    }
}