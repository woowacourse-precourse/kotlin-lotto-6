package lotto.domain.winningResult

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MatchCountTest {
    @Test
    fun `정상적인 객체 생성`() {
        // given
        val input = 70
        // when & then
        assertDoesNotThrow { MatchCount(input) }
    }

    @Test
    fun `음수가 입력 되는 경우 예외 발생`() {
        // given
        val input = -1
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { MatchCount(input) }
            .withMessage("[ERROR] 당첨 횟수는 음수가 될 수 없습니다.")
    }

    @Test
    fun `문자열 출력시 접미사 추가`() {
        // given
        val input = 50
        // when
        val result = MatchCount(input).toString()
        // then
        assertEquals("50개", result)
    }
}