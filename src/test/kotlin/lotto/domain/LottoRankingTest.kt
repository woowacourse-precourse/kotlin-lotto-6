package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankingTest {


    @Test
    fun `수익률 테스트`() {
        assertThat(LottoRanking.of(listOf(
                LottoResult.THREE_MATCH,
                LottoResult.MISS,
                LottoResult.MISS,
                LottoResult.MISS,
                LottoResult.MISS,
                LottoResult.MISS,
                LottoResult.MISS,
                LottoResult.MISS)).totalPrize).isEqualTo(62.5)
        assertThat(LottoRanking.of(listOf(
                LottoResult.THREE_MATCH)).totalPrize).isEqualTo(500.0)
        assertThat(LottoRanking.of(listOf(
                LottoResult.THREE_MATCH,
                LottoResult.FOUR_MATCH)).totalPrize).isEqualTo(2750.0)
    }
}