package lotto

import lotto.model.PurchaseAmount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", "!", " "])
    fun `PurchaseAmount 생성, 숫자가 입력 됐는지`(inputdata: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmount(inputdata)
        }

        assertThat(exception.message).isEqualTo(PurchaseAmount.ERROR_MESSAGE_PURCHASE_AMOUNT_ONLY_DIGIT)
    }

    @Test
    fun `PurchaseAmount 생성, 입력된 숫자가 0보다 큰지`() {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmount("0")
        }

        assertThat(exception.message).isEqualTo(PurchaseAmount.ERROR_MESSAGE_PURCHASE_AMOUNT_THAN_ZERO)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "11", "111", "500"])
    fun `PurchaseAmount 생성, 입력된 숫자가 1,000 단위 인지`(inputdata: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmount(inputdata)
        }

        assertThat(exception.message).isEqualTo(PurchaseAmount.ERROR_MESSAGE_PURCHASE_AMOUNT_UNITS)
    }
}