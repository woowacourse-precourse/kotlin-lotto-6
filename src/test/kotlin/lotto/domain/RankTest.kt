package lotto.domain;


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `6개 번호가 일치하고 보너스 번호가 일치하면 1등`() {
        val rank = Rank.findRankByMatchCountAndBonus(6, hasBonus = true)
        assertEquals(Rank.FIRST, rank)
    }

    @Test
    fun `6개 번호가 일치하고 보너스가 불일치 해도 1등`() {
        val rank = Rank.findRankByMatchCountAndBonus(6, hasBonus = false)
        assertEquals(Rank.FIRST, rank)
    }

    @Test
    fun `5개 번호와 보너스 번호가 일치하면 2등`() {
        val rank = Rank.findRankByMatchCountAndBonus(5, hasBonus = true)
        assertEquals(Rank.SECOND, rank)
    }

    @Test
    fun `5개 번호만 일치하면 3등`() {
        val rank = Rank.findRankByMatchCountAndBonus(5, hasBonus = false)
        assertEquals(Rank.THIRD, rank)
    }

    @Test
    fun `4개 번호가 일치하고 보너스 번호가 일치하면 4등`() {
        val rank = Rank.findRankByMatchCountAndBonus(4, hasBonus = true)
        assertEquals(Rank.FOURTH, rank)
    }

    @Test
    fun `4개 번호가 일치하고 보너스가 불일치 해도 4등`() {
        val rank = Rank.findRankByMatchCountAndBonus(4, hasBonus = false)
        assertEquals(Rank.FOURTH, rank)
    }

    @Test
    fun `3개 번호가 일치하고 보너스 번호가 일치하면 5등`() {
        val rank = Rank.findRankByMatchCountAndBonus(3, hasBonus = true)
        assertEquals(Rank.FIFTH, rank)
    }

    @Test
    fun `3개 번호가 일치하고 보너스가 불일치 해도 5등`() {
        val rank = Rank.findRankByMatchCountAndBonus(3, hasBonus = false)
        assertEquals(Rank.FIFTH, rank)
    }

    @Test
    fun `2개 번호와 보너스 번호가 일치해도 순위가 없음`() {
        val rank = Rank.findRankByMatchCountAndBonus(2, hasBonus = true)
        assertNull(rank)
    }

    @Test
    fun `1개 번호와 보너스 번호가 일치해도 순위가 없음`() {
        val rank = Rank.findRankByMatchCountAndBonus(1, hasBonus = true)
        assertNull(rank)
    }

    @Test
    fun `보너스 번호만 일치해도 순위가 없음`() {
        val rank = Rank.findRankByMatchCountAndBonus(0, hasBonus = true)
        assertNull(rank)
    }
}
