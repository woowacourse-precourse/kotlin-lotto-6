package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test


class LottoResultTest {

    private val winningResults: List<Prize> = listOf(Prize.THIRD, Prize.THIRD, Prize.FOURTH, Prize.NOTHING, Prize.NOTHING, Prize.NOTHING)

    @Test
    fun `찾고자 하는 등수가 티켓에 각각 몇 개 존재하는지 확인할 수 있다`() {
        val expectedTicketCount = 2
        val actualTicketCount = winningResults.count { it == Prize.THIRD }
        assertThat(actualTicketCount).isEqualTo(expectedTicketCount)
    }

    @Test
    fun `등수마다 일치하는 숫자가 몇 개인지 확인할 수 있다`() {
        val expectedBallCount = 5
        val actualBallCount = WinningBallCount.findPrizeBallCount(Prize.THIRD)
        assertThat(actualBallCount).isEqualTo(expectedBallCount)
    }

    @Test
    fun `우승 티켓의 상금이 얼마인지 확인할 수 있다`() {
        val expectedPrize = 1_500_000
        val actualPrize = Prize.THIRD.amount
        assertThat(expectedPrize).isEqualTo(actualPrize)
    }

}