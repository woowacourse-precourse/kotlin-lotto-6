package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import util.Validator.containsOnlyDigits
import util.Validator.isAmountInThousandWon
import util.Validator.isEmptyValue
import util.Validator.isValidNumberFormat

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
            isEmptyValue("")
        }
    }

    @Test
    fun `올바른 숫자 형태를 입력하지 않았을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            isValidNumberFormat("000123")
        }
    }
}
