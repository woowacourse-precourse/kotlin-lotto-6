package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.domain.Player
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PlayerTest {

    private val player = Player()

    @Test
    fun `구매 금액이 숫자가 아니면 예외가 발생한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                player.validatePurchaseAmount("abc")
            }
        }
    }

    @Test
    fun `구매 금액을 입력하지 않으면 예외가 발생한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                player.validatePurchaseAmount(" ")
            }
        }
    }

    @Test
    fun `구매 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                player.validatePurchaseAmount("5123")
            }
        }
    }
}