package lotto

import lotto.model.PurchaseAmount
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountTest {
    @ValueSource(ints = [999, 100_001, -4])
    @ParameterizedTest
    fun `구입 금액이 1,000원 미만, 100,000원 초과면 예외가 발생한다`(int: Int) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(int)
        }
    }

    @ValueSource(ints = [58700, 5800])
    @ParameterizedTest
    fun `구입 금액이 1,000원 단위가 아니면 예외가 발생한다`(int: Int) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(int)
        }
    }

}