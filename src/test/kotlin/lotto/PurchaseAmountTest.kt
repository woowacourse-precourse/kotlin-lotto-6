package lotto

import lotto.domain.PurchaseAmount
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    @Test
    fun `로또 구매 금액이 공백일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.purchaseAmountEmpty(" ")
        }
    }

    @Test
    fun `로또 구매 금액이 문자열인 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.purchaseAmountNotInt("wooteco")
        }
    }

    @Test
    fun `로또 구매 금액이 실수인 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount.purchaseAmountNotInt("3000.0")
        }
    }

    @Test
    fun `로또 구매 금액이 1,000원 단위가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount. NonDivisibleAmount(3900)
        }
    }
}