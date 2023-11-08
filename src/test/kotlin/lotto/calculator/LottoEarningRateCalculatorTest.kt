package lotto.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoEarningRateCalculatorTest {
    @Test
    fun `구매 금액과 총 상금을 비교하여 이익률을 계산한다`() {
        val buyingPrice = 8000
        val totalPrize = 5000L
        val calculator = LottoEarningRateCalculator()

        val earningRate = calculator.calculate(buyingPrice, totalPrize)

        assertThat(earningRate).isEqualTo(62.5f)
    }
}