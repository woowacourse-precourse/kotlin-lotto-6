package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun `로또 구입금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { Money(900) }
    }

    @Test
    fun `로또 구입금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { Money(1500) }
    }

    @Test
    fun `로또 구입금액이 1000원 이상이고 거스름돈이 남지 않으면 예외가 발생하지 않는다`() {
        assertDoesNotThrow { Money(2000) }
    }
}