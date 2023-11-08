package lotto

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.WinningResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningResultTest {

    @Test
    fun `당첨 통계가 정확하게 계산되는지 확인`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val lotto3 = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val lotto4 = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val lotto5 = Lotto(listOf(1, 2, 7, 8, 9, 10))
        val lottoTickets = listOf(lotto1, lotto2, lotto3, lotto4, lotto5)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = WinningResult(lottoTickets, winningNumbers, bonusNumber)
        val statistics = result.calculateStatistics()

        assertEquals(1, statistics[LottoRank.FIRST])
        assertEquals(1, statistics[LottoRank.SECOND])
        assertEquals(1, statistics[LottoRank.FOURTH])
        assertEquals(1, statistics[LottoRank.FIFTH])
    }

    @Test
    fun `수익률이 정확하게 계산되는지 확인`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(7, 8, 9, 10, 11, 12))
        val lotto3 = Lotto(listOf(13, 14, 15, 16, 17, 18))
        val lotto4 = Lotto(listOf(19, 20, 21, 22, 23, 24))
        val lotto5 = Lotto(listOf(25, 26, 27, 28, 29, 30))
        val lottoTickets = listOf(lotto1, lotto2, lotto3, lotto4, lotto5)
        val winningNumbers = listOf(1, 2, 3, 33, 35, 36)
        val bonusNumber = 7

        val result = WinningResult(lottoTickets, winningNumbers, bonusNumber)
        val statistics = result.calculateStatistics()
        val profitRate = result.calculateProfitRate(lottoTickets.size * 1000, result.calculateTotalPrize(statistics))

        assertEquals("100.0", String.format("%,.1f", profitRate))
    }
}