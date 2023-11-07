package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }
    @Test
    fun `로또생성기는 1부터 45까지의 중복되지 않는 숫자 6개를 반환해야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val generatedNumbers = lotto.generateLottoNumbers()

        assertEquals(6, generatedNumbers.size)
        assertTrue(generatedNumbers.all { it in 1..45 })
        assertTrue(generatedNumbers.toSet().size == 6)
    }

    @Test
    fun `matchCount는 당첨 번호와 일치하는 숫자의 개수를 반환해야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        val matchCount = lotto.matchCount(winningNumbers)

        assertEquals(3, matchCount)
    }

}
