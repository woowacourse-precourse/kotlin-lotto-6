package lotto.models

import lotto.models.Purchase.Companion.AMOUNT_UNIT
import lotto.models.Purchase.Companion.AMOUNT_UNIT_ERROR_MESSAGE
import lotto.utils.Extensions.withCommas
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class PurchaseTest {

    @Test
    fun `유효하지 않은 구매 금액 단위에 대해 예외가 발생한다`() {
        val amount = 1500

        val exception = assertThrows<IllegalArgumentException> { Purchase(amount) }

        assertThat(exception.message).isEqualTo(AMOUNT_UNIT_ERROR_MESSAGE.format(AMOUNT_UNIT.withCommas()))
    }

    @Test
    fun `유효한 구매 금액 단위에 대해 예외가 발생하지 않는다`() {
        val amount = 1000

        assertDoesNotThrow { Purchase(amount) }
    }
}