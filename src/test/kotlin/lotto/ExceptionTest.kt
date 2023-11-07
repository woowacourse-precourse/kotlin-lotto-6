package lotto

import lotto.util.Exception.checkPurchaseAmountException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExceptionTest {
    @Test
    fun `inputPurchaseAmountException - 유효한 구매 금액이 주어지면, checkPurchaseAmountException을 호출하면, 예상 결과를 반환해야 함`() {
        // 유효한 금액이 주어지면
        val purchaseAmount = "6000"

        // 예외 호출
        val result = checkPurchaseAmountException(purchaseAmount)

        // 예상 결과 반환
        assertThat(result.getOrNull()).isEqualTo(6000)
    }
}