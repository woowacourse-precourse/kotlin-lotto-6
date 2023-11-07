package lotto.models

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class WinningRankTest {

    @Test
    fun `로또 번호가 당첨 번호 3개와 일치하면 5등이다`() {
        val matchedCount = 3

        val winningRank = WinningRank.find(matchedCount)

        assertThat(winningRank).isEqualTo(WinningRank.FIFTH)
    }

    @Test
    fun `로또 번호가 당첨 번호 4개와 일치하면 4등이다`() {
        val matchedCount = 4

        val winningRank = WinningRank.find(matchedCount)

        assertThat(winningRank).isEqualTo(WinningRank.FOURTH)
    }

    @Test
    fun `로또 번호가 당첨 번호 5개와 일치하면 3등이다`() {
        val matchedCount = 5

        val winningRank = WinningRank.find(matchedCount)

        assertThat(winningRank).isEqualTo(WinningRank.THIRD)
    }

    @Test
    fun `로또 번호가 당첨 번호 5개와 보너스 번호가 일치하면 2등이다`() {
        val matchedCount = 5
        val isMatchedBonus = true

        val winningRank = WinningRank.find(matchedCount, isMatchedBonus)

        assertThat(winningRank).isEqualTo(WinningRank.SECOND)
    }

    @Test
    fun `로또 번호가 당첨 번호 6개가 일치하면 1등이다`() {
        val matchedCount = 6

        val winningRank = WinningRank.find(matchedCount)

        assertThat(winningRank).isEqualTo(WinningRank.FIRST)
    }

    @Test
    fun `당첨 번호에 일치하는 로또 번호의 개수가 당첨 등수의 개수에 해당하지 않으면 등수가 없다`() {
        val matchedCount = 0

        val winningRank = WinningRank.find(matchedCount)

        assertThat(winningRank).isEqualTo(WinningRank.NOTHING)
    }
}