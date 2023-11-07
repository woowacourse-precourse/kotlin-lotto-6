package lotto.models

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class WinningRankTest {

    @Test
    fun `로또 번호가 당첨 번호 3개와 일치하면 3등이다`() {
        val matchedCount = 3

        val winningRank = WinningRank.find(matchedCount)

        assertThat(winningRank).isEqualTo(WinningRank.THREE)
    }
}