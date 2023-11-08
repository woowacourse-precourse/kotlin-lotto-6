package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `매치된 번호의 개수 반환`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winNumbers = listOf(1, 2, 3, 7, 8, 9)
        assertEquals(3, lotto.matchCount(winNumbers))
    }

    @Test
    fun `보너스 번호가 매치 여부 반환`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.matchBonusNumber(1))
        assertFalse(lotto.matchBonusNumber(7))
    }
}
