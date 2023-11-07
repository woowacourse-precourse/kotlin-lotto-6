package lotto.validator.string

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountValidatorTest {
    @Test
    fun `구입 금액이 숫자형이 아닐 경우 예외 발생`() {
        val purchaseAmountValidator = PurchaseAmountValidator()
        val invalidString = "abc"

        assertThrows<IllegalArgumentException>("문자열 $invalidString 은 숫자여야 합니다") {
            purchaseAmountValidator.validate(invalidString)
        }
    }
    @Test
    fun `구입 금액이 1,000원 단위가 아닐 경우 예외 발생`() {
        val purchaseAmountValidator = PurchaseAmountValidator()
        val invalidString = "1200"

        assertThrows<IllegalArgumentException>("문자열 $invalidString 은 1,000원 단위여야 합니다") {
            purchaseAmountValidator.validate(invalidString)
        }
    }
}