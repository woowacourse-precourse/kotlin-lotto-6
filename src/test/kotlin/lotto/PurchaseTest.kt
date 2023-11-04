package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {
    @Test
    fun `구매 금액이 1,000원 단위로 나누어 떨어지지 않으면 예외가 발생한다`() {
        val amounts = listOf(999, 1001, 1100)
        amounts.forEach { amount ->
            assertThrows<IllegalArgumentException> {
                Purchase(amount)
            }
        }
    }
}
