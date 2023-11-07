package lottoreturns

import lottopurchaseamount.LottoPurchaseAmount
import lottoranking.LottoRanking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoReturnsTest {
    private lateinit var lottoReturns: LottoReturns

    @BeforeEach
    fun setUp() {
        lottoReturns = LottoReturnsImpl()
    }

    @Test
    fun `당첨된게 없을 때 수익률 정확하게 나오는지 확인`() {
        val result = lottoReturns.calculate(LottoPurchaseAmount(10000))

        assertThat(result).isEqualTo(0.0)
    }
}