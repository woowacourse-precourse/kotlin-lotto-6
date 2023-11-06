package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ui.Output

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

    @Test
    fun `구매한 로또를 출력하는지 확인`() {
        val buy = Buy()
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val lotto3 = Lotto(listOf(21, 22, 23, 24, 25, 26))
        val lotto4 = Lotto(listOf(31, 32, 33, 34, 35, 36))
        val lotto5 = Lotto(listOf(41, 42, 43, 44, 45, 40))


        val lottos = UserLotto()
        lottos.addUserLotto(lotto1)
        lottos.addUserLotto(lotto2)
        lottos.addUserLotto(lotto3)
        lottos.addUserLotto(lotto4)
        lottos.addUserLotto(lotto5)

        Output.printUserLottos(lottos)
    }
}