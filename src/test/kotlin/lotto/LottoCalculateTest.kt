package lotto

import lotto.model.LottoWinningRankCalculator
import lotto.model.ProfitCalculator
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoCalculateTest {
    private val lottoWinningRankCalculator = LottoWinningRankCalculator()
    private val profitCalculator = ProfitCalculator()
    @Test
    fun `로또 3개를 구매하여 5등이 두개 당첨되었을 때, 상금은 10000원 이다`() {
        val lotteryTickets: List<Lotto> = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )

        val winNumber: List<Int> = listOf(1, 2, 3, 7, 8, 9)
        val bonusNumber = 18
        val wonLotto = lottoWinningRankCalculator.calculateRank(lotteryTickets, winNumber, bonusNumber)

        assertThat(lottoWinningRankCalculator.prize).isEqualTo(10000)
    }

    @Test
    fun `로또 금액은 5000원 이고 상금이 10000원 일 때 수익률은 200% 이다`() {

        val lotteryTickets: List<Lotto> = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18)),
            Lotto(listOf(19, 20, 21, 22, 23, 24)),
            Lotto(listOf(25, 26, 27, 28, 29, 30))
        )
        val amount = 5000
        val winNumber: List<Int> = listOf(1, 2, 3, 7, 8, 9)
        val bonusNumber = 18
        val wonLotto = lottoWinningRankCalculator.calculateRank(lotteryTickets, winNumber, bonusNumber)
        val profitRate = profitCalculator.calculateProfitRate(amount, lottoWinningRankCalculator.prize)

        assertThat(profitRate).isEqualTo("200.0%")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.25", "1.26", "1.27", "1.28", "1.29", "1.30", "1.31", "1.32", "1.33", "1.34"])
    fun `수익률은 소수점 둘째 자리에서 반올림한다`(input: String) {
        val inputAsDouble = input.toDouble()
        val result = profitCalculator.roundDigit(inputAsDouble, 1)

        val expected = 1.3

        assertEquals(expected, result, 0.001)
    }
}