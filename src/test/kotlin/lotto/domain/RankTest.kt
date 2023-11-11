package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `당첨 횟수에 따라 해당 등수의 메시지와 당첨 횟수를 문자열로 반환한다 - 당첨된 경우`() {
        val count = 3
        val rank = Rank.FIFTH
        val expectedMessage = "3개 일치 (5,000원) - 3개\n"
        assertThat(expectedMessage).isEqualTo(rank.getMessage(count))
    }

    @Test
    fun `당첨 횟수에 따라 해당 등수의 메시지와 당첨 횟수를 문자열로 반환한다 - 당첨되지 않은 경우`() {
        val count = 0
        val rank = Rank.FIFTH
        val expectedMessage = "3개 일치 (5,000원) - 0개\n"
        assertThat(expectedMessage).isEqualTo(rank.getMessage(count))
    }

    @Test
    fun `등수에 따라 당첨 금액을 반환한다`() {
        val rank = Rank.FIRST
        val expectedPrize = 2_000_000_000
        assertThat(expectedPrize).isEqualTo(rank.getPrize(rank))
    }

    @Test
    fun `일치한 숫자의 개수와 보너스 번호의 일치 여부에 따라 등수를 반환한다 - 1등인 경우`() {
        val matchedCount = 6
        val bonusMatch = false
        val expectedRank = Rank.FIRST
        assertThat(expectedRank).isEqualTo(Rank.getRank(matchedCount, bonusMatch))
    }

    @Test
    fun `일치한 숫자의 개수와 보너스 번호의 일치 여부에 따라 등수를 반환한다 - 2등인 경우`() {
        val matchedCount = 5
        val bonusMatch = true
        val expectedRank = Rank.SECOND
        assertThat(expectedRank).isEqualTo(Rank.getRank(matchedCount, bonusMatch))
    }

    @Test
    fun `일치한 숫자의 개수와 보너스 번호의 일치 여부에 따라 등수를 반환한다 - 3등인 경우`() {
        val matchedCount = 5
        val bonusMatch = false
        val expectedRank = Rank.THIRD
        assertThat(expectedRank).isEqualTo(Rank.getRank(matchedCount, bonusMatch))
    }

    @Test
    fun `일치한 숫자의 개수와 보너스 번호의 일치 여부에 따라 등수를 반환한다 - 4등인 경우`() {
        val matchedCount = 4
        val bonusMatch = false
        val expectedRank = Rank.FOURTH
        assertThat(expectedRank).isEqualTo(Rank.getRank(matchedCount, bonusMatch))
    }

    @Test
    fun `일치한 숫자의 개수와 보너스 번호의 일치 여부에 따라 등수를 반환한다 - 5등인 경우`() {
        val matchedCount = 3
        val bonusMatch = false
        val expectedRank = Rank.FIFTH
        assertThat(expectedRank).isEqualTo(Rank.getRank(matchedCount, bonusMatch))
    }

    @Test
    fun `일치한 숫자의 개수와 보너스 번호의 일치 여부에 따라 등수를 반환한다 - 당첨되지 않은 경우`() {
        val matchedCount = 2
        val bonusMatch = false
        val expectedRank = Rank.NONE
        assertThat(expectedRank).isEqualTo(Rank.getRank(matchedCount, bonusMatch))
    }
}