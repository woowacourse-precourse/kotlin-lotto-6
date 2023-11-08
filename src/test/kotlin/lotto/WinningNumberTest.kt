package lotto

import domain.lotto.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumberTest {

    @Test
    fun `당첨 번호의 개수가 6개가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber("2,6,9,14,24,32,39,43")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3,4,6 8,9", "2/6,9,14,24,32"])
    fun `당첨 번호를 쉼표로 구분하지 않았을 때`(winningNumber: String) {
        assertThrows<IllegalArgumentException> {
            WinningNumber(winningNumber)
        }
    }

    @Test
    fun `당첨 번호에 숫자가 아닌 문자를 입력했을 때`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber("1,3,4,5,6,a")
        }
    }

    @Test
    fun `당첨 번호에 값이 비어있을 때`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber("1,3,4,5, ,a")
        }
    }

    @Test
    fun `당첨 번호가 1부터 45 사이의 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber("1,3,4,25,33,56")
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있을 때`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber("1,2,2,3,4,5")
        }
    }

}