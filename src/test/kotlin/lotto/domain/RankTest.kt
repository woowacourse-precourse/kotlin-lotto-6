package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RankTest {
    @Test
    fun `숫자가 3개 미만 일치하면 낙첨이다`() {
        val matchedNumbers = Random.nextInt(0, 3)
        val isBonusNumberMatched = false
        assertEquals(Rank.NONE, Rank.fromMatchedNumbers(matchedNumbers, isBonusNumberMatched))
    }

    @Test
    fun `숫자가 3개 일치하면 5등 당첨이다`() {
        val matchedNumbers = 3
        val isBonusNumberMatched = false
        assertEquals(Rank.FIFTH, Rank.fromMatchedNumbers(matchedNumbers, isBonusNumberMatched))
    }

    @Test
    fun `숫자가 4개 일치하면 4등 당첨이다`() {
        val matchedNumbers = 4
        val isBonusNumberMatched = false
        assertEquals(Rank.FOURTH, Rank.fromMatchedNumbers(matchedNumbers, isBonusNumberMatched))
    }

    @Test
    fun `숫자가 5개 일치하고 보너스 숫자가 일치하지 않으면 3등 당첨이다`() {
        val matchedNumbers = 5
        val isBonusNumberMatched = false
        assertEquals(Rank.THIRD, Rank.fromMatchedNumbers(matchedNumbers, isBonusNumberMatched))
    }

    @Test
    fun `숫자가 5개 일치하고 보너스 숫자가 일치하면 2등 당첨이다`() {
        val matchedNumbers = 5
        val isBonusNumberMatched = true
        assertEquals(Rank.SECOND, Rank.fromMatchedNumbers(matchedNumbers, isBonusNumberMatched))
    }

    @Test
    fun `숫자가 6개 일치하면 1등 당첨이다`() {
        val matchedNumbers = 6
        val isBonusNumberMatched = false
        assertEquals(Rank.FIRST, Rank.fromMatchedNumbers(matchedNumbers, isBonusNumberMatched))
    }
}