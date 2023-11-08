package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ProfitTest {

    @ParameterizedTest
    @CsvSource(
        "1000, 1000, 100.0",
        "2000000000, 15000, 13333333.3",
        "5000, 8000, 62.5"
    )
    fun `수익금과 투자금으로 수익률을 계산한다`(totalProfit: Int, payment: Int, expected: Double) {
        val profit = Profit(totalProfit)
        val result = profit.calculateProfitRate(payment)

        assertThat(result).isEqualTo(expected)
    }
}