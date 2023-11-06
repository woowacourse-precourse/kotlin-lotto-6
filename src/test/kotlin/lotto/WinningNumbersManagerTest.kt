package lotto

import model.WinningNumbersManager
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersManagerTest {

    @Test
    fun `중복된 번호가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbersManager(listOf("1", "2", "3", "33", "33", "4"))
        }
    }

    @Test
    fun `정상 범위를 벗어난 숫자가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbersManager(listOf("1", "2", "3", "33", "46", "4"))
        }
    }

    @Test
    fun `숫자가 아닌 다른 문자가 포함되어 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbersManager(listOf("1", "2", "3", "33", "test", "4"))
        }
    }

    @Test
    fun `당첨 번호 내 올바르지 못한 숫자 형식을 갖고 있는 숫자가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbersManager(listOf("1", "2", "3", "4", "5", "06"))
        }
    }

    @Test
    fun `당첨 번호가 6개가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbersManager(listOf("1", "2", "3", "4", "5"))
        }
    }

    @Test
    fun `입력되지 않은 번호가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbersManager(listOf("1", "2", "3", "4", "5", ""))
        }
    }
}
