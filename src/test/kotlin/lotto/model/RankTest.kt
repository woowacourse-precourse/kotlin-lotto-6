package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `각각 맞춘 횟수에 부합하는 상금을 반환한다`() {
        val rank1 = Rank.of(6, false)
        val rank2 = Rank.of(5, true)
        val rank3 = Rank.of(5, false)
        val rank4 = Rank.of(4, false)
        val rank5 = Rank.of(3, false)
        val noRank = Rank.of(0, false)

        assertThat(rank1?.prize).isEqualTo(Rank.First.prize)
        assertThat(rank2?.prize).isEqualTo(Rank.Second.prize)
        assertThat(rank3?.prize).isEqualTo(Rank.Third.prize)
        assertThat(rank4?.prize).isEqualTo(Rank.Fourth.prize)
        assertThat(rank5?.prize).isEqualTo(Rank.Fifth.prize)
        assertThat(noRank).isNull()
    }
}