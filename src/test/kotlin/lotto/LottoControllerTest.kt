package lotto

import lotto.domain.Lotto
import lotto.domain.LottoController
import lotto.utils.LottoRank
import lotto.view.InputView
import lotto.view.OutputView
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


class LottoControllerTest {
    val lotto = LottoController(InputView(), OutputView())

    @Test
    fun `로또번호와 당첨번호 그리고 보너스 번호를 비교한 결과 테스트`() {
        val lotteries =
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 9)), Lotto(listOf(1, 3, 4, 9, 15, 16)))
        val prizeLottoNumber = listOf(1, 2, 3, 4, 5, 9)
        val bonusNumber = 1
        val result = lotto.countLottoMatch(lotteries, prizeLottoNumber, bonusNumber)
        val answer = mutableMapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 1,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 1,
            LottoRank.FIFTH to 0
        )
        assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `수익률 계산 테스트`() {
        val money = 12_000
        val prize = 2_030_000
        val result = lotto.calculateProfit(money, prize)
        val answer = 16_916.668f
        assertThat(result).isEqualTo(answer)
    }
}
