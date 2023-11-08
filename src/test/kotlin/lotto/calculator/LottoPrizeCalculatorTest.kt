package lotto.calculator

import lotto.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPrizeCalculatorTest {
    @Test
    fun `로또 랭킹들을 종합하여 로또 총 상금을 계산한다`() {
        val calculator = LottoPrizeCalculator()
        val lottoRanks = listOf(LottoRank.FIFTH, LottoRank.FIFTH, LottoRank.FIRST)

        val totalPrize = calculator.calculate(lottoRanks)

        assertThat(totalPrize).isEqualTo(5_000 * 2 + 2_000_000_000)
    }
}