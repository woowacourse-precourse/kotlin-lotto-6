package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `3개 미만 일치 시 없음`() {
        assertRank(2, false, LottoRank.NONE)
    }

    @Test
    fun `3개 일치 시 5등`() {
        assertRank(3, false, LottoRank.FIFTH)
    }

    @Test
    fun `4개 일치 시 4등`() {
        assertRank(4, false, LottoRank.FOURTH)
    }

    @Test
    fun `5개 일치하고 보너스볼 일치하지 않을 때 3등`() {
        assertRank(5, false, LottoRank.THIRD)
    }

    @Test
    fun `5개 일치하고 보너스볼 일치할 때 2등`() {
        assertRank(5, true, LottoRank.SECOND)
    }

    @Test
    fun `6개 일치 시 1등`() {
        assertRank(6, false, LottoRank.FIRST)
    }

    private fun assertRank(matchCount: Int, matchBonus: Boolean, expectedRank: LottoRank) {
        val rank = LottoRank.getRank(matchCount, matchBonus)
        assertEquals(expectedRank, rank)
    }
}
