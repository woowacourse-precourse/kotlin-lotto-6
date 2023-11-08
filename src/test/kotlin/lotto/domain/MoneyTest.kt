package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = [5000, 100, 7777, 0])
    fun `정상적인 객체 생성`(input: Int) {
        // when & then
        assertDoesNotThrow { Money(input) }
    }

    @Test
    fun `음수 예외 처리`() {
        // given
        val input = -1
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Money(input) }
            .withMessage("[ERROR] 금액은 음수가 될 수 없습니다.")
    }

    @Test
    fun `문자열 출력시 세자리마다 콤마를 찍고 접미사를 붙여 출력`() {
        // given
        val input = 2000000000
        // when
        val result = Money(input).toString()
        // then
        assertEquals("2,000,000,000원", result)
    }
}