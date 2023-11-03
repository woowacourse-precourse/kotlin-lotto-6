package lotto.validator

import lotto.exception.InputException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

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
        val exception = assertThrows<IllegalArgumentException> { InputValidator.validateInputPurchaseAmount(input) }
        assertThat(exception.message).isEqualTo(InputException.STRING_BLANK.message)
    }

    @Test
    fun `구입금액 입력 검증 - 숫자 외 입력`() {
        // given
        val input = "abcd"
        // when & then
        val exception = assertThrows<IllegalArgumentException> { InputValidator.validateInputPurchaseAmount(input) }
        assertThat(exception.message).isEqualTo(InputException.NOT_INTEGER.message)
    }
}