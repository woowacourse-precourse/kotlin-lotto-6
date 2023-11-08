package lotto.model.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Nested
    inner class `로또 번호의 개수가 6개가 아닌 경우` {

        @Test
        fun `로또 번호가 6개보다 작으면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5))
            }
        }

        @Test
        fun `로또 번호가 6개보다 크면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
            }
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호의 범위가 1~45가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 50))
        }
    }

    @Test
    fun `로또 번호가 오름차순으로 정렬되어 반환된다`() {
        val lotto = Lotto(listOf(6, 2, 3, 1, 5, 4))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.toAscendingNumbers())
    }

    @Test
    fun `로또 번호에 특정 숫자가 포함되어 있는지 확인한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.isContainNumber(1))
        assertFalse(lotto.isContainNumber(7))
    }

    @Nested
    inner class `당첨 번호와 일치하는 숫자의 개수를 확인한다` {
        @Test
        fun `3개 일치`() {
            val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val lotto2 = Lotto(listOf(4, 5, 6, 7, 8, 9))
            assertEquals(3, lotto1.getCountOfMatch(lotto2))
        }

        @Test
        fun `4개 일치`() {
            val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val lotto2 = Lotto(listOf(3, 4, 5, 6, 7, 8))
            assertEquals(4, lotto1.getCountOfMatch(lotto2))
        }

        @Test
        fun `5개 일치`() {
            val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val lotto2 = Lotto(listOf(2, 3, 4, 5, 6, 7))
            assertEquals(5, lotto1.getCountOfMatch(lotto2))
        }

        @Test
        fun `6개 일치`() {
            val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6))
            assertEquals(6, lotto1.getCountOfMatch(lotto2))
        }
    }
}
