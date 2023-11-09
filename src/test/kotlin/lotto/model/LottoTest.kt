package lotto.model

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

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 1등 당첨 테스트`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val actual = Lotto(lottoNumbers).matchAnswer(ANSWER, BONUS)
        assertEquals(actual, WinningType.FIRST)
    }

    @Test
    fun `로또 2등 당첨 테스트`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 7)
        val actual = Lotto(lottoNumbers).matchAnswer(ANSWER, BONUS)
        assertEquals(actual, WinningType.SECOND)
    }

    @Test
    fun `로또 3등 당첨 테스트`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 8)
        val actual = Lotto(lottoNumbers).matchAnswer(ANSWER, BONUS)
        assertEquals(actual, WinningType.THIRD)
    }

    @Test
    fun `로또 4등 당첨 테스트`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 7, 8)
        val actual = Lotto(lottoNumbers).matchAnswer(ANSWER, BONUS)
        assertEquals(actual, WinningType.FOURTH)
    }

    @Test
    fun `로또 5등 당첨 테스트`() {
        val lottoNumbers = listOf(1, 2, 3, 7, 8, 9)
        val actual = Lotto(lottoNumbers).matchAnswer(ANSWER, BONUS)
        assertEquals(actual, WinningType.FIFTH)
    }

    @Test
    fun `로또 꽝 테스트`() {
        val lottoNumbers = listOf(1, 2, 7, 8, 9, 10)
        val actual = Lotto(lottoNumbers).matchAnswer(ANSWER, BONUS)
        assertEquals(actual, WinningType.NOTHING)
    }

    companion object {
        private val ANSWER = listOf(1, 2, 3, 4, 5, 6)
        private const val BONUS = 7
    }


}
