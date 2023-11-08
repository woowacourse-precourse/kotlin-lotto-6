package lotto.study

import org.assertj.core.api.Assertions.*
import org.assertj.core.api.ThrowableAssert
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringTest {

    // 요구 사항 1
    @Test
    fun `2개가 있을 경우`() {
        val input = "1,2"
        val result = input.split(",")

        assertThat(result).contains("1", "2")
    }

    @Test
    fun `1개만 있을 경우`() {
        val input = "1"
        val result = input.split(",")

        assertThat(result).containsExactly("1")
    }

    // 요구 사항 2
    @Test
    fun `2개만 있을 경우`() {
        val input = "(1,2)"
        val result = input.substring(1, input.length - 1)

        assertThat(result).isEqualTo("1,2")
    }

    @Test
    fun `괄호안에 아무것도 없을 경우`() {
        val input = "()"
        val result = input.substring(1, input.length - 1)

        assertThat(result).isEqualTo("")
    }

    @Test
    fun `예외 케이스 발생`() {
        val input = "(1,2"

        assertThrows<IndexOutOfBoundsException> {
            removeParentheses(input)
        }
    }

    private fun removeParentheses(input: String): String {
        if (input.startsWith("(") && input.endsWith(")")) {
            return input.substring(1, input.length - 1)
        } else {
            throw IndexOutOfBoundsException("Unbalanced parentheses")
        }
    }

    // 요구 사항 3
    @Test
    @DisplayName("정상적인 위치의 문자 가져오기")
    fun `정상적인 위치의 문자 가져오기`() {
        val input = "abc"
        val result = input[1]

        assertThat(result).isEqualTo('b')
    }

    @Test
    @DisplayName("위치를 벗어난 문자 가져오기")
    fun `위치를 벗어난 문자 가져오기`() {
        val input = "abc"

        assertThatThrownBy { input[3] }
            .isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasMessage("String index out of range: 3")
    }

}