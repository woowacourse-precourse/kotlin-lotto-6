package lotto

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
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
        fun `checkIsOverZero 메서드 사용 시 입력값이 0 이하일 때 예외 발생`() {
            val input = "0"

            assertThrows<IllegalArgumentException> { Validator.checkIsOverZero(input) }
        }
    }

    @Nested
    @DisplayName("당첨 번호")
    class Winning {

        @Test
        @DisplayName("예외1")
        fun `checkHasSeparator 메서드 사용 시 입력값이 주어진 구분자로 구분되어있지 않을 때 예외 발생`() {
            val input = "0 1 2"

            assertThrows<IllegalArgumentException> { Validator.checkHasSeparator(input, COMMA) }
        }

        @Test
        @DisplayName("예외2")
        fun `checkIsInBoundary 메서드 사용 시 입력값이 주어진 범위를 벗어났을 때 예외 발생`() {
            val input = 31

            assertThrows<IllegalArgumentException> {
                Validator.checkIsInBoundary(input, MIN_NUMBER, MAX_NUMBER)
            }
        }

        @Test
        @DisplayName("예외3")
        fun `checkIsContained 메서드 사용 시 입력값이 주어진 배열 안에 존재할 때 예외 발생`() {
            val input = "b"
            val items = listOf("a", "b", "c")

            assertThrows<IllegalArgumentException> { Validator.checkIsNotContained(input, items) }
        }

        companion object {
            private const val COMMA = ","
            private const val MIN_NUMBER = 0
            private const val MAX_NUMBER = 30
        }
    }
}