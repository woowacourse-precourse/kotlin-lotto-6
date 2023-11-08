package lotto.validator

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
            .withMessage("[ERROR] 빈 값이 입력되었습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcd", "2147483648", "-2147483649"])
    fun `구입금액 입력 검증 - Int 범위 초과 입력`(input: String) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { InputValidator.validateInputPurchaseAmount(input) }
            .withMessage("[ERROR] 숫자를 입력해주세요.")
    }

    @Test
    fun `당첨 번호 입력 검증 - 정상 입력`() {
        // given
        val input = listOf("1", "2", "3")
        // when & then
        assertDoesNotThrow { InputValidator.validateInputWinningNumbers(input) }
    }

    @Test
    fun `당첨 번호 입력 검증 - 빈 값 포함`() {
        // given
        val input = listOf("1", "", "3")
        // when & then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { InputValidator.validateInputWinningNumbers(input) }
            .withMessage("[ERROR] 빈 값이 입력되었습니다.")
    }

    @Test
    fun `당첨 번호 입력 검증 - Int 범위 초과 입력`() {
        // given
        val input = listOf("2147483648", "-2147483649", "abcdef")
        // when & then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { InputValidator.validateInputWinningNumbers(input) }
            .withMessage("[ERROR] 숫자를 입력해주세요.")
    }
}