package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    @Test
    fun `당첨 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5, 5),
                bonus =  7
            )
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                numbers = listOf(1, 2, 3, 4, 5, 6),
                bonus =  1
            )
        }
    }
}
