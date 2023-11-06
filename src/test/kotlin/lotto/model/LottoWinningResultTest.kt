package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningResultTest {
    @Test
    fun `로또 당첨 결과 로또 당첨 결과 맵에 테스트`() {
        var lottoResult: LottoResult = LottoResult()
        var matchingLottoNumCount = mutableListOf<Int>(1, 2, 0, 4, 0)
        lottoResult.setMatchingLottoResult(matchingLottoNumCount)

        assertThat(lottoResult.getMatchingLottoResult()).isEqualTo(
            mutableMapOf(
                LottoMatchNum.THREE_MATCH to 1,
                LottoMatchNum.FOUR_MATCH to 2,
                LottoMatchNum.FIVE_MATCH to 0,
                LottoMatchNum.FIVE_PLUS_BONUS to 4,
                LottoMatchNum.SIX_MATCH to 0
            )
        )
    }
    @Test
    fun `로또 당첨 결과 따른 당첨금 계산 테스트 value1`() {
        var lottoResult: LottoResult = LottoResult()
        var matchingLottoNumCount = mutableListOf<Int>(0, 0, 0, 0, 1)
        lottoResult.setMatchingLottoResult(matchingLottoNumCount)
        lottoResult.calculateTotalLottoPrize()

        assertThat(lottoResult.getTotalLottoPrize()).isEqualTo(2000000000)
    }

    @Test
    fun `로또 당첨 결과 따른 당첨금 계산 테스트 value2`() {
        var lottoResult: LottoResult = LottoResult()
        var matchingLottoNumCount = mutableListOf<Int>(1, 1, 1, 1, 1)
        lottoResult.setMatchingLottoResult(matchingLottoNumCount)
        lottoResult.calculateTotalLottoPrize()

        assertThat(lottoResult.getTotalLottoPrize()).isEqualTo(2031555000)
    }

    @Test
    fun `로또 당첨 결과 따른 당첨금 계산 테스트 value3`() {
        var lottoResult: LottoResult = LottoResult()
        var matchingLottoNumCount = mutableListOf<Int>(0, 0, 0, 0, 0)
        lottoResult.setMatchingLottoResult(matchingLottoNumCount)
        lottoResult.calculateTotalLottoPrize()

        assertThat(lottoResult.getTotalLottoPrize()).isEqualTo(0)
    }
}