package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,3,4,6 8,9", "2/6,9,14,24,32"])
    fun `당첨 번호를 쉼표로 구분하지 않았을 때`(winningNumber: String) {
        assertThrows<IllegalArgumentException> {
            WinningNumber(winningNumber)
        }
    }

}