package lotto.models

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {

    @Test
    fun `유효하지 않은 구매 금액 단위에 대해 예외가 발생한다`() {
        val amount = 1500

        val exception = assertThrows<IllegalArgumentException> { Purchase(amount) }

        assertThat(exception.message).isEqualTo(Purchase.INVALID_AMOUNT_ERROR_MESSAGE)
    }
}