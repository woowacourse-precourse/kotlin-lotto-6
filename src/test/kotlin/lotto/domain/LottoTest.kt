package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호는 6개여야 한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
        assertEquals("Failed requirement.", exception.message)
    }

    @Test
    fun `로또 번호는 중복되지 않아야 한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 1, 2, 3, 4, 5))
        }
        assertEquals("Failed requirement.", exception.message)
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
