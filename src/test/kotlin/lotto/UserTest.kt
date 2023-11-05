package lotto

import lotto.model.User
import lotto.util.Constant.UNIT_PRICE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {

    private val user = User()

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            user.setPrice(12500)
        }
    }

    @Test
    fun `사용자는 구입 금액만큼 로또를 발행 받아야한다`() {
        val price = 10000
        user.setPrice(price)
        user.buyLotto()
        assertEquals(user.lottoes.size, price / UNIT_PRICE)
    }
}