package lotto

import lotto.utils.Exceptions.inputPurchaseAmountException
import lotto.utils.Exceptions.inputWinningNumberException
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

    @Test
    fun `inputWinningNumberException - Given 유효한 당첨 번호가 주어지면, When inputWinningNumberException을 호출하면, Then Lotto 객체를 반환해야 함`() {
        // Given
        val winningNumber = listOf("1", "2", "3", "4", "5", "6")

        // When
        val result = inputWinningNumberException(winningNumber)

        // Then
        assertThat(result.getOrNull()).isInstanceOf(Lotto::class.java)
    }

    @Test
    fun `inputWinningNumberException - Given 유효하지 않은 당첨 번호가 주어지면, When & Then NumberFormatException을 던져야 함`() {
        // Given
        val winningNumber = listOf("1", "2", "invalidNumber", "4", "5", "6")

        // When & Then
        assertThatThrownBy { inputWinningNumberException(winningNumber).getOrThrow() }.isInstanceOf(
                NumberFormatException::class.java
            )
    }

}