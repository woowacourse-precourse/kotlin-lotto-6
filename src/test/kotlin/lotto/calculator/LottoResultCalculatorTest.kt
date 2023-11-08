package lotto.calculator

import lotto.LottoRank
import lotto.model.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultCalculatorTest {
    @Test
    fun `로또 랭킹 리스트와 구매 금액으로 로또 게임의 결과를 반환한다`() {
        val calculator = LottoResultCalculator()
        val buyingPrice = 8000
        val lottoRanks = listOf(LottoRank.FIFTH)

        val lottoRank = calculator.calculate(buyingPrice, lottoRanks)

        assertThat(lottoRank).isEqualTo(
            LottoResult(
                mapOf(
                    LottoRank.FIFTH to 1
                ),
                62.5f
            )
        )
    }
}