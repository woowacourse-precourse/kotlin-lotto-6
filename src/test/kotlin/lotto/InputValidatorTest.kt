package lotto

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import lotto.InputValidator as Validator

class InputValidatorTest {

    @Test
    @DisplayName("공백 여부")
    fun `checkIsNotBlank 메서드 사용 시 입력값이 공백일 때 예외 발생`() {
        val input = ""

        assertThrows<IllegalArgumentException> { Validator.checkIsNotBlank(input) }
    }

    @Test
    @DisplayName("정수 여부")
    fun `checkIsDigit 메서드 사용 시 입력값이 정수의 형태가 아닐 때 예외 발생`() {
        val input = "11.5"

        assertThrows<IllegalArgumentException> { Validator.checkIsDigit(input) }
    }

    @Test
    @DisplayName("구분자 유무")
    fun `checkHasCommaSeparator 메서드 사용 시 입력값이 쉼표(',') 로 구분되어있지 않을 때 예외 발생`() {
        val input = "0 1 2"

        assertThrows<IllegalArgumentException> { Validator.checkHasCommaSeparator(input) }
    }
}