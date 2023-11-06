package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoPurchaseAmountTest {
    @Test
    fun `금액에 음수값 입력 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmount("-1000")
        }
    }

    @Test
    fun `금액에 공백 입력 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmount(" ")
        }
    }

    @Test
    fun `금액에 1000으로 나누어 떨어지지 않는 입력 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmount("1001")
        }
    }
}
