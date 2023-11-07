package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    private val validator = Validator()

    @Test
    fun `구입 금액이 입력이 없는 경우, 오류를 반환한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount("")
        }
    }

    @Test
    fun `구입 금액이 정수가 아닌 경우, 오류를 반환한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseInt("100a")
        }
    }

    @Test
    fun `구입 금액이 1000원 보다 작은 경우, 오류를 반환한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseRange(123)
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닌 경우, 오류를 반환한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePriceUnit(15600)
        }
    }
}