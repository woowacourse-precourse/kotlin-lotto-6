package lotto.calculator

import lotto.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankCounterTest {
    @Test
    fun `로또 랭킹 리스트를 종합하여 로또 랭킹의 개수를 계산한다`() {
        val counter = LottoRankCounter()
        val lottoRanks = listOf(LottoRank.FIFTH, LottoRank.FIFTH, LottoRank.FIRST)

        val lottoRankCounts = counter.count(lottoRanks)

        assertThat(lottoRankCounts).isEqualTo(
            mapOf(
                LottoRank.FIFTH to 2,
                LottoRank.FIRST to 1
            )
        )
    }
}