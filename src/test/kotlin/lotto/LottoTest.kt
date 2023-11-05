package lotto

import org.junit.jupiter.api.Assertions.assertEquals
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
    fun `로또 번호의 개수가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }
    @Test
    fun `calculateResult 메소드가 올바른 Rank를 반환하는지 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        assertEquals(Rank.FIRST, lotto.calculateResult(winningNumbers, bonusNumber))
    }

    @Test
    fun `getSortedNumbers 메소드가 정렬된 숫자를 반환하는지 테스트`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getSortedNumbers())
    }

    @Test
    fun `matchCount 메소드가 올바른 일치 번호 개수를 반환하는지 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        assertEquals(3, lotto.matchCount(winningNumbers))
    }
}