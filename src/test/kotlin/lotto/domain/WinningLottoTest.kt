package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningLottoTest {
    private lateinit var winningLotto: WinningLotto
    private val lottoTickets = mutableListOf<Lotto>()
    private val lotto_3rd = Lotto(listOf(1, 2, 3, 4, 5, 9))
    private val lotto_2nd = Lotto(listOf(1, 2, 3, 7, 5, 4))
    private val lotto_none = Lotto(listOf(5, 6, 7, 8, 9, 10))
    private val lotto_5th = Lotto(listOf(5, 6, 4, 8, 9, 10))

    @BeforeEach
    fun init() {
        winningLotto = WinningLotto(
            listOf(1, 2, 3, 4, 5, 6), 7
        )
        lottoTickets.clear()
    }

    @Test
    fun `3등 당첨 2개와 2등 당첨 1개일때 result값이 업데이트된다`() {
        lottoTickets.add(lotto_3rd)
        lottoTickets.add(lotto_2nd)
        lottoTickets.add(lotto_3rd)

        winningLotto.checkLottoTicketResult(lottoTickets)
        val results = winningLotto.results

        assert(results[Rank.SECOND] == 1)
        assert(results[Rank.THIRD] == 2)
    }

    @Test
    @DisplayName("총 8장을 구매하여 그중 5등에 1개 당첨되었다면 수익률은 62.5%이다")
    fun calculateProfitRate() {
        val lottoTicketsCount = 8
        lottoTickets.add(lotto_5th)
        repeat(7) { lottoTickets.add(lotto_none) }
        winningLotto.checkLottoTicketResult(lottoTickets)

        val profitRate = winningLotto.calculateProfitRate(lottoTicketsCount)
        assertEquals(62.5f, profitRate)
    }

    @Test
    fun calculateProfit() {
        val results1 = mutableMapOf<Rank, Int>(
            Rank.FIFTH to 5,
            Rank.FOURTH to 2,
            Rank.THIRD to 3,
            Rank.SECOND to 0,
            Rank.FIRST to 0,
        )
        assertEquals(4625000f, mockCalculateProfit(results1))

        val results2 = mutableMapOf<Rank, Int>(
            Rank.FIFTH to 0,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.SECOND to 0,
            Rank.FIRST to 0,
        )
        assertEquals(0f, mockCalculateProfit(results2))
    }

    fun mockCalculateProfit(results: Map<Rank, Int>): Float {
        var profit = 0f
        results.forEach { (rank, count) ->
            profit += rank.prize * count
        }
        return profit
    }
}