package lotto

import lotto.data.Money
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    @DisplayName("최소값")
    fun `돈이 0 보다 작거나 같을 때 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Money(-1)
        }
    }

    @Test
    @DisplayName("1000 단위")
    fun `돈이 1000 으로 나누어 떨어지지 않을 때 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Money(999)
        }
    }
}