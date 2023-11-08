package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {
    @Test
    fun `심판은 로또들의 랭킹을 매겨준다`() {
        val referee = Referee(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 7, 8)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
        )

        val lottoRanks = referee.determineRank(lottos)
        assertThat(lottoRanks).isEqualTo(
            listOf(
                LottoRank.FIRST, LottoRank.SECOND,
                LottoRank.THIRD, LottoRank.FOURTH,
                LottoRank.FIFTH
            )
        )
    }

    @Test
    fun `심판은 None Ranker는 무시한다 `() {
        val referee = Referee(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val lottos = Lotto(listOf(1, 2, 7, 8, 9, 10))

        val lottoRank = referee.determineRank(listOf(lottos))

        assertThat(lottoRank).isEqualTo(listOf<LottoRank>())
    }
}