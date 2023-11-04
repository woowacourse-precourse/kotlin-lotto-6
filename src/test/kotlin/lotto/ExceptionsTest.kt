package lotto

import lotto.utils.Exceptions.inputPurchaseAmountException
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class ExceptionsTest {
    @Test
    fun `inputPurchaseAmountException - Given 유효한 구매 금액이 주어지면, When inputPurchaseAmountException을 호출하면, Then 예상 결과를 반환해야 함`() {
        // Given
        val purchaseAmount = "2000"

        // When
        val result = inputPurchaseAmountException(purchaseAmount)

        // Then
        assertThat(result.getOrNull()).isEqualTo(2000)
    }

    @Test
    fun `inputPurchaseAmountException - Given 유효하지 않은 구매 금액이 주어지면, When & Then NumberFormatException을 던져야 함`() {
        // Given
        val purchaseAmount = "invalidAmount"

        // When & Then
        assertThatThrownBy { inputPurchaseAmountException(purchaseAmount).getOrThrow() }.isInstanceOf(
                NumberFormatException::class.java
            )
    }

}