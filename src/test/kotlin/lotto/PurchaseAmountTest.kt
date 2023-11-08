package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    private val purchaseAmount = PurchaseAmount()
    @Test
    fun `구입금액이 1000보다 작으면 예외가 발생한다(음수인 경우)`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount.validateLottoNumbers(-5)
        }
    }

    @Test
    fun `구입금액이 1000보다 작으면 예외가 발생한다(양수인 경우)`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount.validateLottoNumbers(100)
        }
    }

    @Test
    fun `구입금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount.validateLottoNumbers(1234)
        }
    }

    @Test
    fun `구입금액이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount.validateLottoNumbers("invalid".toInt())
        }
    }

    @Test
    fun `구입금액 정상 입력`() {
        assertDoesNotThrow {
            purchaseAmount.validateLottoNumbers(3000)
        }
    }
}