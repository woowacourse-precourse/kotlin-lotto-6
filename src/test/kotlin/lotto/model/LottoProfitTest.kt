package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoProfitTest {
    private val lottoProfit = LottoProfit()

    @Test
    @DisplayName("로또 수익률이 올바르게 출력되는지 테스트한다")
    fun calculateRateTest() {
        val case1Input = listOf(0, 0, 0, 0, 1)
        lottoProfit.calculateRate(case1Input, 8000)
        val case1Rate = lottoProfit.rate
        val case1Result = 62.5
        assertThat(case1Rate).isEqualTo(case1Result)


        val case2Input = listOf(0, 0, 0, 0, 2)
        lottoProfit.calculateRate(case2Input, 8000)
        val case2Rate = lottoProfit.rate
        val case2Result = 125.0
        assertThat(case2Rate).isEqualTo(case2Result)
    }
}