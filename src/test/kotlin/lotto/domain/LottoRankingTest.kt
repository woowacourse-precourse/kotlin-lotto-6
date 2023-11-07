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
                LottoResult.MISS)).totalRevenue).isEqualTo(62.5)
        assertThat(LottoRanking.of(listOf(
                LottoResult.THREE_MATCH)).totalRevenue).isEqualTo(500.0)
        assertThat(LottoRanking.of(listOf(
                LottoResult.THREE_MATCH,
                LottoResult.FOUR_MATCH)).totalRevenue).isEqualTo(2750.0)
    }
}