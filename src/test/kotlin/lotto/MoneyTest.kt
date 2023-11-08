package lotto

import model.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    fun `숫자가 아닌 문자가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("1234567980.0")
        }
    }

    @Test
    fun `1,000원 단위가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("28800")
        }
    }

    @Test
    fun `값을 입력하지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("")
        }
    }

    @Test
    fun `올바른 숫자 형태를 입력하지 않았을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("000123")
        }
    }

    @Test
    fun `1회 최대 구매 가능 금액보다 높은 금액일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("120000")
        }
    }

    @Test
    fun `로또 금액보다 낮은 금액을 입력하였을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("500")
        }
    }

    @Test
    fun `과도하게 큰 값을 입력하였을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("100000000000000000")
        }
    }
}
