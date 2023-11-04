package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import util.Validator.containsOnlyDigits

class BuyingPriceTest {
    @Test
    fun `숫자가 아닌 문자가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            containsOnlyDigits("1234567980.0")
        }
    }
}
