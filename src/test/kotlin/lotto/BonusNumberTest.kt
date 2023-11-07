package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class BonusNumberTest {
    @Test
    fun `보너스 번호가 1보다 작으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(-1, listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `보너스 번호가 45보다 크면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(50, listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `당첨 번호로 입력한 숫자와 보너스 번호가 중복된다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(3, listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `당첨 번호가 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("invalid".toInt(), listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `보너스 번호 정상 입력`() {
        assertDoesNotThrow { BonusNumber(10, listOf(1, 2, 3, 4, 5, 6)) }
    }
}