package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `결과 생성 시 당첨 횟수 초기화 테스트`() {
        val lottoResult = LottoResult()
        val expectedCount = 0
        val counts = Rank.entries.map { lottoResult.getRankCount(it) }
        assertThat(counts).allMatch { count ->
            count == expectedCount
        }
    }

    @Test
    fun `등수에 따라 당첨 횟수를 증가시킨다`() {
        val lottoResult = LottoResult()
        val rank = Rank.FIFTH
        lottoResult.updateCount(rank)
        val expectedCount = 1
        assertThat(expectedCount).isEqualTo(lottoResult.getRankCount(rank))
    }

    @Test
    fun `당첨 통계를 문자열로 반환한다 - 모두 1개씩 당첨된 경우`() {
        val lottoResult = LottoResult()
        for (rank in Rank.entries) {
            lottoResult.updateCount(rank)
        }
        val expectedString = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n"
        assertThat(expectedString).isEqualTo(lottoResult.toString())
    }

    @Test
    fun `당첨 통계를 문자열로 반환한다 - 아무것도 당첨되지 않은 경우`() {
        val lottoResult = LottoResult()
        val rank = Rank.NONE
        lottoResult.updateCount(rank)
        val expectedString = "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n"
        assertThat(expectedString).isEqualTo(lottoResult.toString())
    }
}