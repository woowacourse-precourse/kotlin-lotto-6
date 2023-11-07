package lotto.`model`

import lotto.domain.Lotto
import lotto.domain.User
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            User(1200, listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))))
        }
    }

    @Test
    fun `구입 금액 만큼 로또를 구매하지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            User(3000, listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12))))
        }
    }
}