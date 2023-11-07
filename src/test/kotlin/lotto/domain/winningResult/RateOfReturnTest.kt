package lotto.domain.winningResult

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RateOfReturnTest {
    @Test
    fun `문자열 출력시 소수점 둘째 자리에서 반올림하고 접미사를 붙여 출력`() {
        // given
        val input = 77.768
        // when
        val result = RateOfReturn(input).toString()
        // then
        assertEquals("77.8%", result)
    }
}