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
}
