package lotto

import lotto.domain.Purchase
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class Amount {
    @Test
    fun `구입 금액이 숫자가 아니다`() {
        assertThrows<IllegalArgumentException> {
            Purchase.publicCheckValidationAmount("a8000b")
            Purchase.publicCheckValidationAmount("1000q")
        }
    }

    @Test
    fun `구입 금액이 0원이다`() {
        assertThrows<IllegalArgumentException> {
            Purchase.publicCheckValidationAmount("0")
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니다`() {
        assertThrows<IllegalArgumentException> {
            Purchase.publicCheckValidationAmount("8500")
            Purchase.publicCheckValidationAmount("500")
        }
    }
}
