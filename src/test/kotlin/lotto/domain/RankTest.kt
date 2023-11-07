package lotto.domain

import lotto.domain.model.Rank
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `enum 파라미터인 prize를 string 에서 int로 변환하여 상금 금액으로 반환한다`() {
        val rank = Rank.FIRST_PLACE
        Assertions.assertThat(rank.getPrize()).isEqualTo(2000000000)
    }

    @Test
    fun `enum list 생성 확인`() {
        Assertions.assertThat(Rank.getList()).isEqualTo(
            listOf(
                Rank.FIFTH_PLACE,
                Rank.FOURTH_PLACE,
                Rank.THIRD_PLACE,
                Rank.SECOND_PLACE,
                Rank.FIRST_PLACE,
            ),
        )
    }

    @Test
    fun `count와 isBonusNum을 파라미터로 받으면 등수를 반환한다`() {
        Assertions.assertThat(Rank.getPlace(3, false)).isEqualTo(Rank.FIFTH_PLACE)
        Assertions.assertThat(Rank.getPlace(4, false)).isEqualTo(Rank.FOURTH_PLACE)
        Assertions.assertThat(Rank.getPlace(5, false)).isEqualTo(Rank.THIRD_PLACE)
        Assertions.assertThat(Rank.getPlace(6, true)).isEqualTo(Rank.SECOND_PLACE)
        Assertions.assertThat(Rank.getPlace(6, false)).isEqualTo(Rank.FIRST_PLACE)
    }
}
