package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BuyTest {
    @Test
    fun `구입 금액이 1000원단위가 아닐때 예외처리`() {
        assertThrows<IllegalArgumentException> {
            Buy().validateMoney("1010")
        }
    }
    @Test
    fun `입력받은 값이 숫자가 아닐때`() {
        assertThrows<IllegalArgumentException> {
            Buy().validateMoney("abc")
        }
    }
}