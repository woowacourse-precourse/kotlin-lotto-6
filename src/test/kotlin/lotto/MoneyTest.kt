package lotto

import lotto.model.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    fun `구입 금액이 1000 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money().moneyChangesValidate("19999")
        }
    }
    @Test
    fun `구입 금액이 1000 이하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money().moneyRangeValidate("199")
        }
    }
}