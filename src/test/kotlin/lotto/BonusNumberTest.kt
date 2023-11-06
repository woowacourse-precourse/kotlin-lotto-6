package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `보너스 번호 예외처리 테스트`() {
        var bonusNumber = BonusNumber()
        var input = 46
        assertThrows<IllegalArgumentException> { bonusNumber.checkValidBonusNumber(input) }
    }
}