package lotto

import lotto.domain.purchase.LottoPurchaseAmountParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoPurchaseAmountTest {
    @Test
    fun `금액에 음수값 입력 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmountParser.parse("-1000")
        }
    }

    @Test
    fun `금액에 공백 입력 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmountParser.parse(" ")
        }
    }

    @Test
    fun `금액에 1000으로 나누어 떨어지지 않는 입력 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmountParser.parse("1001")
        }
    }
}
