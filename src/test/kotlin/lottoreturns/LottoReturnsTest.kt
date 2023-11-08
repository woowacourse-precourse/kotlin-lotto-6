package lottoreturns

import lottopurchaseamount.LottoPurchaseAmount
import lottoranking.LottoRanking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoReturnsTest {
    private lateinit var lottoReturns: LottoReturns

    @BeforeEach
    fun setUp() {
        lottoReturns = LottoReturnsImpl()
        LottoRanking.entries.forEach { it.count = 0 }
    }

    @Test
    fun `당첨된게 없을 때 수익률 정확하게 나오는지 확인`() {
        val result = lottoReturns.calculate(LottoPurchaseAmount(10000))

        assertThat(result).isEqualTo(0.0)
    }

    @ParameterizedTest
    @MethodSource("generateData")
    fun `각 등수 하나 당첨됐을때 수익률 정확하게 나오는지 확인`(lottoRanking: LottoRanking, lottoReturn: Double) {
        lottoRanking.count++

        val result = lottoReturns.calculate(LottoPurchaseAmount(10000))

        assertThat(result).isEqualTo(lottoReturn)
    }

    companion object {
        @JvmStatic
        fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(LottoRanking.FIRST, 2.0E7),
                Arguments.of(LottoRanking.SECOND, 300000.0),
                Arguments.of(LottoRanking.THIRD, 15000.0),
                Arguments.of(LottoRanking.FOURTH, 500.0),
                Arguments.of(LottoRanking.FIFTH, 50.0),
            )
        }
    }
}