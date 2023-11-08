package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val winningLottoNum = listOf(
        listOf(1, 2, 3, 16, 32, 38),
        listOf(11, 24, 33, 43, 32, 38), listOf(13, 14, 16, 38, 42, 45)
    )

    @Test
    fun `3개가 동일 할때 5등이다`() {
        val lottoUser = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7
        val calculator = Calculator()
        calculator.compareNum(lottoUser, bonus, winningLottoNum)
        val compareResult = calculator.lottoResult
        val lottoResult = mapOf<MatchedCount, Int>(
            MatchedCount.FIFTH to 1,
            MatchedCount.FOURTH to 0,
            MatchedCount.THIRD to 0,
            MatchedCount.SECOND to 0,
            MatchedCount.FIRST to 0,
        )
        assertThat(compareResult).isEqualTo(lottoResult)
    }
}