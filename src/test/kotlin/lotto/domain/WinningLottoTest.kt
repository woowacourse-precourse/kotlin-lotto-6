package lotto.domain

import lotto.domain.WinningLotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `당첨 번호의 개수가 6개가 아닐 경우 예외가 발생한다`() {
        val underLengthException = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1,2,3,4,5,6,7),8)
        }
        val upperLengthException = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1,2,3,4,5),6)
        }
        assertEquals(underLengthException.message,upperLengthException.message)
    }

    @Test
    fun `당첨 번호의 숫자들은 1~45의 범위를 벗어나면 예외가 발생한다`() {
        val overRangeException = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1,2,3,4,5,47,),8)
        }
        val underRangeException = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(0,2,3,4,5,6),8)
        }
        assertEquals(overRangeException.message,underRangeException.message)
    }

    @Test
    fun `당첨 번호의 숫자가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1,2,3,4,5,5),8)
        }
    }

    @Test
    fun `보너스 번호가 1~45의 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1,2,3,4,5,6),48)
        }
    }

    @Test
    fun `보너스 번호가 당첨번호와 일치하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1,2,3,4,5,6),6)
        }
    }
}