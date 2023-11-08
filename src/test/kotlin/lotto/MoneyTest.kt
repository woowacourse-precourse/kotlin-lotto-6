package lotto

import lotto.domain.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class MoneyTest {

    @Test
    fun `금액이 1000원으로 나누어 떨어지지 않을 경우 테스트`() {
        val money = "1100"
        assertThrows<IllegalArgumentException> { Money(money) }
    }

    @Test
    fun `금액이 숫자가 아닐 경우 테스트`() {
        val money = "1100k"
        assertThrows<IllegalArgumentException> { Money(money) }
    }


}
