package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PlayerTest {


    @Test
    @DisplayName("로또를 8개 구입했을 때 수익률은 62.5%이다")
    fun `calculate_revenue`() {
        val money = Money(8000)
        val rank = mutableMapOf(
            WinningRank.NO_MATCHES to 0,
            WinningRank.THREE_MATCHES to 1,
            WinningRank.FOUR_MATCHES to 0,
            WinningRank.FIVE_MATCHES to 0,
            WinningRank.FIVE_MATCHES_WITH_BONUS_NUMBER to 0,
            WinningRank.SIX_MATCHES to 0
        )
        val player = Player(money)
        Assertions.assertThat(player.calculateRevenue(rank).equals(62.5))
    }

}