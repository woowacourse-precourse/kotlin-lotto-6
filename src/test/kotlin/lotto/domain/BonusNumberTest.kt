package lotto.domain

import lotto.BonusNumber
import lotto.checkValidBonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `보너스 번호 예외처리 테스트(범위 초과)`() {
        val invalidInput = "46"
        assertThrows<IllegalArgumentException> {
            checkValidBonusNumber(invalidInput)
        }
    }
}