package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningResultTest {
    @Test
    fun `로또 당첨 결과 로또 당첨 결과 맵에 테스트`() {
        var lottoResult: LottoResult = LottoResult()
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(3))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(3))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(4))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(4))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(6))

        assertThat(lottoResult.getMatchingLottoResult()).isEqualTo(
            mutableMapOf(
                LottoMatchNum.THREE_MATCH to 2,
                LottoMatchNum.FOUR_MATCH to 2,
                LottoMatchNum.FIVE_MATCH to 0,
                LottoMatchNum.FIVE_PLUS_BONUS to 4,
                LottoMatchNum.SIX_MATCH to 1
            )
        )
    }
    @Test
    fun `로또 당첨 결과 따른 당첨금 계산 테스트 value1`() {
        var lottoResult: LottoResult = LottoResult()
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(6))
        lottoResult.calculateTotalLottoPrize()

        assertThat(lottoResult.getTotalLottoPrize()).isEqualTo(2000000000)
    }

    @Test
    fun `로또 당첨 결과 따른 당첨금 계산 테스트 value2`() {
        var lottoResult: LottoResult = LottoResult()
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(3))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(4))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(5))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(6))
        lottoResult.calculateTotalLottoPrize()

        assertThat(lottoResult.getTotalLottoPrize()).isEqualTo(2031555000)
    }

    @Test
    fun `로또 당첨 결과 따른 당첨금 계산 테스트 value3`() {
        var lottoResult: LottoResult = LottoResult()
        lottoResult.calculateTotalLottoPrize()

        assertThat(lottoResult.getTotalLottoPrize()).isEqualTo(0)
    }

    @Test
    fun `로또 당첨금에 따른 수익률 계산 테스트 value1`(){
        var lottoResult: LottoResult = LottoResult()
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(3))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(3))
        lottoResult.calculateTotalLottoPrize()
        lottoResult.calculateLottoReturnOfRate(8000)

        assertThat(lottoResult.getTotalLottoRateOfReturn()).isEqualTo(125.0)
    }

/*    @Test
    fun `로또 당첨금에 따른 수익률 계산 테스트 value2`(){
        var lottoResult: LottoResult = LottoResult()
        lottoResult.calculateLottoReturnOfRate(5000, 8000)

        assertThat(lottoResult.getTotalLottoRateOfReturn()).isEqualTo(62.5)
    }*/

    @Test
    fun `로또 당첨금에 따른 수익률 계산 테스트 value2`(){
        var lottoResult: LottoResult = LottoResult()
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(6))
        lottoResult.calculateTotalLottoPrize()
        lottoResult.calculateLottoReturnOfRate(8000)

        assertThat(lottoResult.getTotalLottoRateOfReturn()).isEqualTo(25000000.0)
    }
}