package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import util.Calculator.clearWinningAmountValue
import util.Calculator.getProfitPercentage
import util.Calculator.plusWinningAmount

class CalculatorTest {
    @Test
    fun `수익률 반환값을 확인한다`() {
        clearWinningAmountValue()
        plusWinningAmount(5, 1)
        val result = String.format("%.1f", getProfitPercentage(8))
        assertThat(result).isEqualTo("62.5")
    }

    @Test
    fun `1등 수익률 반환값을 확인한다`() {
        clearWinningAmountValue()
        plusWinningAmount(1, 1)
        val result = String.format("%.1f", getProfitPercentage(1))
        assertThat(result).isEqualTo("200000000.0")
    }
}
