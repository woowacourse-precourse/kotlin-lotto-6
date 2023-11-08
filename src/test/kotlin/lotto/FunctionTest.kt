package lotto

import lotto.model.Jackpot
import lotto.model.Rank
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
        val rank = mutableMapOf(
            Rank.THIRD to 2,
            Rank.FOURTH to 1,
            Rank.FIFTH to 3,
            Rank.FIFTH_WITH_BONUS to 0,
            Rank.SIXTH to 5
        )

        // 테스트 케이스 1: 3개 일치 추가
        val updatedRank1 = Jackpot().rankUpdate(3, rank, false)
        Assertions.assertEquals(3, updatedRank1[Rank.THIRD])
    }
}