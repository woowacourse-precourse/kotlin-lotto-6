package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `3개 미만 일치 시 없음`() {
        val rank = LottoRank.getRank(2, false)
        assertEquals(LottoRank.NONE, rank)
    }

    @Test
    fun `3개 일치 시 5등`() {
        val rank = LottoRank.getRank(3, false)
        assertEquals(LottoRank.FIFTH, rank)
    }

    @Test
    fun `4개 일치 시 4등`() {
        val rank = LottoRank.getRank(4, false)
        assertEquals(LottoRank.FOURTH, rank)
    }

    @Test
    fun `5개 일치하고 보너스볼 일치하지 않을 때 3등`() {
        val rank = LottoRank.getRank(5, false)
        assertEquals(LottoRank.THIRD, rank)
    }

    @Test
    fun `5개 일치하고 보너스볼 일치할 때 2등`() {
        val rank = LottoRank.getRank(5, true)
        assertEquals(LottoRank.SECOND, rank)
    }

    @Test
    fun `6개 일치 시 1등`() {
        val rank = LottoRank.getRank(6, false)
        assertEquals(LottoRank.FIRST, rank)
    }
}
