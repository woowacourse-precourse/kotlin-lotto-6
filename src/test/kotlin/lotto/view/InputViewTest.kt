package lotto.view

import lotto.domain.purchase.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {

    @Test
    fun `사용자로부터 입력받은 금액이 문자열 형태인 경우 예외 발생`() {
        val amount = "금액"
        assertThrows<IllegalArgumentException> {
            Money(amount)
        }
    }

    @Test
    fun `사용자로부터 입력받은 금액이 음수 형태인 경우 예외 발생`() {
        val amount = "-1000"
        assertThrows<IllegalArgumentException> {
            Money(amount)
        }
    }

    @Test
    fun `사용자로부터 입력받은 금액이 1,000으로 나누어 떨어지지 않는 경우 예외 발생`() {
        val amount = "1010"
        assertThrows<IllegalArgumentException> {
            Money(amount)
        }
    }
}