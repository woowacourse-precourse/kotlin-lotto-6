package lotto.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputMoneyValidatorTest {
    private val validator = InputMoneyValidator()

    @ParameterizedTest
    @ValueSource(strings = ["", "test", "1000j"])
    fun `구입 금액 검증 테스트 - 숫자가 아닌 형식을 입력한 경우`(inputMoney: String) {
        assertThrows<IllegalArgumentException> { validator.validate(inputMoney) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1001", "100", "999"])
    fun `구입 금액 검증 테스트 - 1000으로 나누어 떨어지지 않는 수를 입력한 경우`(inputMoney: String) {
        assertThrows<IllegalArgumentException> { validator.validate(inputMoney) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }
}