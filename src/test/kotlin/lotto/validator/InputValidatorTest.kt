package lotto.validator

import lotto.exception.InputException
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `구입금액 입력 검증 - 정상 입력`() {
        // given
        val input = "7000"
        // when & then
        assertDoesNotThrow { InputValidator.validateInputPurchaseAmount(input) }
    }

    @Test
    fun `구입금액 입력 검증 - 빈 값 입력`() {
        // given
        val input = ""
        // when & then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { InputValidator.validateInputPurchaseAmount(input) }
            .withMessage(InputException.STRING_BLANK.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcd", "2147483648", "-2147483649"])
    fun `구입금액 입력 검증 - Int 범위 초과 입력`(input: String) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { InputValidator.validateInputPurchaseAmount(input) }
            .withMessage(InputException.NOT_INTEGER.message)
    }
}