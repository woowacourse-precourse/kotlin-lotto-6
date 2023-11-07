package lotto

import lotto.controller.BonusNumberTest
import lotto.controller.WinningNumberTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `보너스 숫자가 0보다 작은 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberTest(listOf("1", "2", "3", "4", "5", "6"), 0)
        }
    }

    @Test
    fun `보너스 숫자가 45보다 클 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberTest(listOf("1", "2", "3", "4", "5", "6"), 46)
        }
    }

    @Test
    fun `보너스 숫자 내부에 문자가 발견될 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberTest(listOf("1", "2", "3", "4", "5", "6"), "1?".toInt())
        }
    }

    @Test
    fun `당첨 숫자 내부에 보너스 숫자가 발견될 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberTest(listOf("1", "2", "3", "4", "5", "6"), 1)
        }
    }

}