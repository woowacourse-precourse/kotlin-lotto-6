package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import util.Validator.containsOnlyDigits
import util.Validator.isAmountInThousandWon

class BuyingPriceTest {
    @Test
    fun `숫자가 아닌 문자가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            containsOnlyDigits("1234567980.0")
        }
    }

    @Test
    fun `1,000원 단위가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            isAmountInThousandWon("28800")
        }
    }

    @Test
    fun `값을 입력하지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            require("".isEmpty())
        }
    }
}
