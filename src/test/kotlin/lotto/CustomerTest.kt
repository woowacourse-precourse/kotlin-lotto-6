package lotto

import lotto.utils.Validate.validatePay
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomerTest {
    @Test
    fun `로또 구매 금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validatePay(500)
        }
    }

    @Test
    fun `로또 구매 금액이 100000을 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validatePay(100001)
        }
    }

    @Test
    fun `로또 구매 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validatePay(1500)
        }
    }
}