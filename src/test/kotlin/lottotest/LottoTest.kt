package lottotest

import lotto.Lotto
import lotto.LottoModel
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `당첨 번호와 일치하는 번호 개수 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(4, 5, 6, 7, 8, 9)

        assertEquals(3, lotto.matchCount(winningNumbers))
    }

    @Test
    fun `보너스 번호가 로또 번호에 포함되는지 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 3

        assertFalse(lotto.hasBonusNumber(bonusNumber))
    }

    @Test
    fun `로또 구매 시 올바른 개수의 로또가 생성되는지 확인`() {
        val lottoModel = LottoModel()
        val price = 5000
        val lottos = lottoModel.buyLotto(price)

        assertEquals(5, lottos.size)
    }

}