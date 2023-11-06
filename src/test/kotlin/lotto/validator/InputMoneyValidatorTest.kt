package lotto.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputMoneyValidatorTest {
    private val validator = InputMoneyValidator()

    @Test
    fun `구입 금액 검증 테스트 - 공백을 입력한 경우`() {
        val inputMoney = ""
        assertThrows<IllegalArgumentException> { validator.validate(inputMoney) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `구입 금액 검증 테스트 - 숫자가 아닌 형식을 입력한 경우`() {
        val inputMoney = "test"
        assertThrows<IllegalArgumentException> { validator.validate(inputMoney) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `구입 금액 검증 테스트 - 1000으로 나누어 떨어지지 않는 수를 입력한 경우`() {
        val inputMoney = "1001"
        assertThrows<IllegalArgumentException> { validator.validate(inputMoney) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `구입 금액 검증 테스트 - 1000 이하의 수를 입력한 경우`() {
        val inputMoney = "999"
        assertThrows<IllegalArgumentException> { validator.validate(inputMoney) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }
}