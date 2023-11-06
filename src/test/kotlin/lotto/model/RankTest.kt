package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RankTest {

    @Test
    fun `각각 맞춘 횟수에 부합하는 상금을 반환한다`() {
        val rank1 = Rank.of(6, false)
        val rank2 = Rank.of(5, true)
        val rank3 = Rank.of(5, false)
        val rank4 = Rank.of(4, false)
        val rank5 = Rank.of(3, false)
        val noRank = Rank.of(0, false)

        assertThat(rank1?.prize).isEqualTo(Rank.Prize.First.money)
        assertThat(rank2?.prize).isEqualTo(Rank.Prize.Second.money)
        assertThat(rank3?.prize).isEqualTo(Rank.Prize.Third.money)
        assertThat(rank4?.prize).isEqualTo(Rank.Prize.Fourth.money)
        assertThat(rank5?.prize).isEqualTo(Rank.Prize.Fifth.money)
        assertThat(noRank).isNull()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 10, 6])
    fun `범위에 벗어나는 랭크 값일 경우, 오류를 반환한다`(value: Int) {
        assertThatThrownBy { Rank(value) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Rank.OUT_OF_RANGE_ERROR)
    }
}