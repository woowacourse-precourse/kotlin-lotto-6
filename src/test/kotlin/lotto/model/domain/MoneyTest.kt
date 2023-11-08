package lotto.model.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    fun `금액이 0 이하이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(0)
        }
    }

    @Test
    fun `금액이 1000 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(999)
        }
    }
}