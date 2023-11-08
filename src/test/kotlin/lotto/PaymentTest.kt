package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PaymentTest {

    @Test
    fun `금액의 입력값이 숫자가 아닐때`() {
        val input = "글자"
        assertThrows<IllegalArgumentException> {
            Payment(input)
        }
    }

    @Test
    fun `금액의 입력값이 1000원단위가 아닐 때`() {
        val input = "1234"
        assertThrows<IllegalArgumentException> {
            Payment(input)
        }
    }
}