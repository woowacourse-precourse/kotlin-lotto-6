package lotto

import lotto.util.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidateTest {
    @Test
    fun `입력된 금액이 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateUnit(1234)
        }
    }

    @Test
    fun `입력된 값이 정수가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateInteger("123abc")
        }
    }

    @Test
    fun `입력된 값이 자연수가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateNatural("-12")
        }
    }

    @Test
    fun `입력된 값이 존재하지 않는 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateNull("")
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 중복되는 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateDuplicate(listOf(1,2,3,4,5,6), 1)
        }
    }

    @Test
    fun `당첨 번호에 중복되는 값이 존재하는 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateLottoDuplicate(listOf(1,2,3,4,4,5))
        }
    }

    @Test
    fun `입력된 정수가 범위를 벗어난 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateRange(46)
        }
    }
}