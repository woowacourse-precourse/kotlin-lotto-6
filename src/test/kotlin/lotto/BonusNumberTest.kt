package lotto

import lotto.lottonumber.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `보너스 번호에 숫자가 아닌 문자를 입력했을 때`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("a")
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 사이의 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("50")
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호에 포함되어 있을 때`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("20", listOf(1, 3, 5, 20, 28, 40))
        }
    }

}