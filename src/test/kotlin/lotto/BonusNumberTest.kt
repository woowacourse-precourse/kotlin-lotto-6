package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    private val validator = Validator()

    @Test
    fun `보너스 번호의 입력이 없는 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumberInput("")
        }
    }

    @Test
    fun `보너스 번호가 정수가 아닌 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("a")
        }
    }

    @Test
    fun `보너스 번호가 1에서 45이외의 값인 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumberRange(55)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복된 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusRepeat(5, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}