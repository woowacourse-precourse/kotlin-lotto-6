package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaserTest {

    @Test
    fun `구매자는 1000원 이상의 금액을 입력해야 한다`() {
        assertThrows<IllegalArgumentException> {
            Purchaser(500)
        }
    }

    @Test
    fun `구매자는 1000원 단위의 금액을 입력해야 한다`() {
        assertThrows<IllegalArgumentException> {
            Purchaser(1500)
        }
    }
}