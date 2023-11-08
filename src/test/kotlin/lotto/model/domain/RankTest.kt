package lotto.model.domain

import lotto.model.domain.Rank.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `1등 테스트`() {
        val countOfMatch = 6
        val isBonus = false
        val actual = Rank.findRank(countOfMatch, isBonus)
        assertThat(actual).isEqualTo(FIRST)
    }

    @Test
    fun `2등 테스트`() {
        val countOfMatch = 5
        val isBonus = true
        val actual = Rank.findRank(countOfMatch, isBonus)
        assertThat(actual).isEqualTo(SECOND)
    }

    @Test
    fun `3등 테스트`() {
        val countOfMatch = 5
        val isBonus = false
        val actual = Rank.findRank(countOfMatch, isBonus)
        assertThat(actual).isEqualTo(THIRD)
    }

    @Test
    fun `4등 테스트`() {
        val countOfMatch = 4
        val isBonus = false
        val actual = Rank.findRank(countOfMatch, isBonus)
        assertThat(actual).isEqualTo(FOURTH)
    }

    @Test
    fun `5등 테스트`() {
        val countOfMatch = 3
        val isBonus = false
        val actual = Rank.findRank(countOfMatch, isBonus)
        assertThat(actual).isEqualTo(FIFTH)
    }

    @Test
    fun `미당첨 테스트`() {
        val countOfMatch = 1
        val isBonus = true
        val actual = Rank.findRank(countOfMatch, isBonus)
        assertThat(actual).isEqualTo(NONE)
    }
}