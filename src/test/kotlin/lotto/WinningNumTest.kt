package lotto

import lotto.domain.WinningNum
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class WinningNumTest {
    @Test
    fun `당첨 번호 입력시 숫자와 콤마로 이루어진 문자열이 아닐 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            WinningNum("4;7,5,3,9,10")
        }
    }

}
