package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.model.Bonus

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    fun `보너스가 답과 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus().BonuDuplicationValidate(1, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `보너스가 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus().BonusFomatValidate(";")
        }
    }

    @Test
    fun `보너스가 범위내가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus().BonusRangeValidate(46)
        }
    }
}