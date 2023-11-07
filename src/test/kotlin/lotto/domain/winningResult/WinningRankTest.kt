package lotto.domain.winningResult

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningRankTest {
    @Test
    fun `일치하는 번호 개수와 보너스 번호 일치 여부에 따른 당첨 결과`() {
        // given
        val matchingCounts = listOf(3, 4, 5, 6)
        val bonusNumberMatched = listOf(true, false, true, false)

        // when & then
        assertEquals(WinningRank.FIFTH, WinningRank.getRank(matchingCounts[0], bonusNumberMatched[0]))
        assertEquals(WinningRank.FOURTH, WinningRank.getRank(matchingCounts[1], bonusNumberMatched[1]))
        assertEquals(WinningRank.SECOND, WinningRank.getRank(matchingCounts[2], bonusNumberMatched[2]))
        assertEquals(WinningRank.FIRST, WinningRank.getRank(matchingCounts[3], bonusNumberMatched[3]))
    }
}