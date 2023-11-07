package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `보너스 번호에 숫자가 아닌 문자를 입력했을 때`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("a")
        }
    }

}