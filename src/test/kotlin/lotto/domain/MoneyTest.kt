package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun `정상적인 객체 생성`() {
        // given
        val input = 5000
        // when & then
        assertDoesNotThrow { Money(input) }
    }

    @Test
    fun `객체 생성시 1,000 단위가 아닐 경우 예외 처리`() {
        // given
        val input = 1001
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Money(input) }
            .withMessage("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.")
    }

    @Test
    fun `객체 생성시 1,000 보다 적을 경우 예외 처리`() {
        // given
        val input = 0
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Money(input) }
            .withMessage("[ERROR] 구입금액은 최소 1000원 이상 입력해야 합니다.")
    }
}