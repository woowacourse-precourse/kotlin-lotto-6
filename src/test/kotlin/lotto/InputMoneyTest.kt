package lotto

import lotto.controller.BonusNumberTest
import lotto.controller.InputMoneyTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputMoneyTest {

    @Test
    fun `로또 구입 금액이 1,000단위로 나뉘어지지 않을 시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputMoneyTest(1200)
        }
    }

    @Test
    fun `로또 구입 금액 내부에 문자가 발견될 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputMoneyTest("1,000".toInt())
        }
    }

}