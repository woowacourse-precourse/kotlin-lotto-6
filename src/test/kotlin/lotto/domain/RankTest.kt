package lotto.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `of 메서드 사용시 당첨 번호 일치 개수와 보너스 일치 여부에 따라 등수에 맞는 상수를 반환`() {
        assertSimpleTest {
            assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST)
            assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND)
            assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD)
            assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH)
            assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH)
            assertThat(Rank.of(0, false)).isEqualTo(Rank.NOTHING)
        }
    }
}