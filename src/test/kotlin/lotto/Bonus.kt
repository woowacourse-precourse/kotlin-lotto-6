package lotto

import lotto.domain.BonusNumber
import lotto.domain.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class Bonus {
    @Test
    fun `보너스 번호가 숫자가 아니다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber.publicCheckValidationBonusNumber("jj")
        }
    }

    @Test
    fun `보너스 번호가 1미만 혹은 45초과의 숫자이다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber.publicCheckValidationBonusNumber("46")
            BonusNumber.publicCheckValidationBonusNumber("0")
        }
    }

    @Test
    fun `당첨 번호와 중복이다`() {
        val testNumbers = mutableListOf(1,2,3,4,5,6)
        WinningNumber.testSetWinningIntNumber(testNumbers)
        assertThrows<IllegalArgumentException> {
            BonusNumber.publicCheckValidationBonusNumber("1")
        }
    }
}
