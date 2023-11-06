package lotto

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import lotto.InputValidator as Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    @DisplayName("공백 여부")
    fun `checkIsNotBlank 메서드 사용 시 입력값이 공백일 때 예외 발생`() {
        val input = ""

        assertThrows<IllegalArgumentException> { Validator.checkIsNotBlank(input) }
    }

    @Test
    @DisplayName("정수 여부")
    fun `checkIsNumeric 메서드 사용 시 입력값이 정수의 형태가 아닐 때 예외 발생`() {
        val input = "11.5"

        assertThrows<IllegalArgumentException> { Validator.checkIsNumeric(input) }
    }

    @Nested
    @DisplayName("로또 구입 금액")
    class Money {

        @Test
        @DisplayName("예외1")
        fun `checkDividedAsThousand 메서드 사용 시 입력값이 1000 으로 나누어 떨어지지 않을 때 예외 발생`() {
            val input = "1200"

            assertThrows<IllegalArgumentException> { Validator.checkDividedAsThousand(input) }
        }

        @Test
        @DisplayName("예외2")
        fun `checkIsNotZero 메서드 사용 시 입력값이 0 일 때 예외 발생`() {
            val input = "0"

            assertThrows<IllegalArgumentException> { Validator.checkIsNotZero(input) }
        }
    }
}