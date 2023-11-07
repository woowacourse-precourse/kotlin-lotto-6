package lotto.domain.winningResult

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningResultTest {
    @Test
    fun `문자열 출력`() {
        // given
        val result = mapOf(
            WinningRank.FIRST to MatchCount(1),
            WinningRank.SECOND to MatchCount(2),
            WinningRank.THIRD to MatchCount(3)
        )
        val rateOfReturn = RateOfReturn(62.5)
        val winningResult = WinningResult(result, rateOfReturn)

        // when
        val resultString = winningResult.toString()

        // then
        val expectedString =
                "6개 일치 (2,000,000,000원) - 1개" + System.lineSeparator() +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개" + System.lineSeparator() +
                "5개 일치 (1,500,000원) - 3개" + System.lineSeparator() +
                "총 수익률은 62.5%입니다."
        assertEquals(expectedString, resultString)
}
}