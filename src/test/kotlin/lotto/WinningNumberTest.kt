package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    @Test
    fun `당첨 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5, 5),
                bonus = 7
            )
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5, 6),
                bonus = 1
            )
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5, 6, 7),
                bonus = 1
            )
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개보다 작으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5),
                bonus = 1
            )
        }
    }

    @Test
    fun `당첨 번호 숫자가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5, 46),
                bonus = 1
            )
        }
    }

    @Test
    fun `보너스 번호 숫자가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5, 6),
                bonus = 46
            )
        }
    }
}
