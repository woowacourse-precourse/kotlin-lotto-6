package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "!", " "])
    fun `구입 금액에 문자가 입력되면, 예외가 발생한다`(inputdata: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmount(inputdata)
        }

        assertThat(exception.message).isEqualTo(PurchaseAmount.ERROR_MESSAGE_PURCHASE_AMOUNT_ONLY_DIGIT)
    }

    @Test
    fun `구입 금액에 0보다 작은 수가 들어오면, 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmount("0")
        }

        assertThat(exception.message).isEqualTo(PurchaseAmount.ERROR_MESSAGE_PURCHASE_AMOUNT_THAN_ZERO)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "11", "111", "500"])
    fun `구입 금액이 1,000 단위가 아니면, 예외가 발생한다`(inputdata: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmount(inputdata)
        }

        assertThat(exception.message).isEqualTo(PurchaseAmount.ERROR_MESSAGE_PURCHASE_AMOUNT_UNITS)
    }
}