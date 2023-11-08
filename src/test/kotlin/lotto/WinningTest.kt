package lotto

import lotto.domain.compareToLotto
import lotto.domain.getEarningRate
import lotto.domain.matchCheck
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningTest {
    @Test
    fun `당첨 번호 비교 테스트`() {
        // given
        val lottos = mutableListOf(Lotto(listOf(1,2,3,4,5,6)))
        val total = listOf(1,2,3,4,5,7)
        val bonus = 6

        // when
        val match = compareToLotto(lottos, total, bonus)

        // then
        assertEquals(5, match.first[0])
        assertEquals(1, match.second)
    }

    @Test
    fun `당첨 횟수 테스트`() {
        // given
        val count = mutableListOf(1,3,4)
        val bonus = 1
        val matches = Pair(count, bonus)

        // when
        val result = matchCheck(matches)

        // then
        assertEquals(mutableListOf(1,1,0,1,0), result)
    }
}