package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoProfitTest {
    private lateinit var lottoProfit: LottoProfit

    @BeforeEach
    fun setUp() {
        val input = listOf(0, 0, 0, 0, 1)
        val purchasePrice = 8000
        lottoProfit = LottoProfit(input, purchasePrice)
    }


    @Test
    @DisplayName("로또 수익률이 올바르게 출력되는지 테스트한다")
    fun calculateRateTest() {
        assertThat(lottoProfit.rate).isEqualTo("62.5")

        resetSetting()
        assertThat(lottoProfit.rate).isEqualTo("200000000.0")
    }

    fun resetSetting() {
        val input = listOf(1, 0, 0, 0, 0)
        val purchasePrice = 1000
        lottoProfit = LottoProfit(input, purchasePrice)
    }
}