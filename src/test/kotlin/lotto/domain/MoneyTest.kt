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
}