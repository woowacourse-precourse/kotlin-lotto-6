package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `LottoRank 열거형 클래스의 increment와 getCount 메서드 테스트`() {
        val lottoRank = LottoRank.THREE_MATCH
        assertEquals(0, lottoRank.getCount())
        lottoRank.increment()
        assertEquals(1, lottoRank.getCount())
        lottoRank.increment()
        lottoRank.increment()
        assertEquals(3, lottoRank.getCount())
        val lottoRank2 = LottoRank.FOUR_MATCH
        assertEquals(0, lottoRank2.getCount())
        lottoRank2.increment()
        assertEquals(1, lottoRank2.getCount())
    }
}