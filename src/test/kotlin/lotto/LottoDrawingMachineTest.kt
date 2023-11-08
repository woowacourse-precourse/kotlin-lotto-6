package lotto.model

import lotto.model.domain.Bonus
import lotto.model.domain.Lotto
import lotto.model.domain.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoDrawingMachineTest {

    @Test
    fun `getRankCounts 메소드 테스트`() {
        // given
        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(2, 3, 4, 5, 6, 7)),
            Lotto(listOf(2, 3, 4, 5, 6, 8)),
            Lotto(listOf(3, 4, 5, 6, 7, 8)),
            Lotto(listOf(4, 5, 6, 7, 8, 9)),
            Lotto(listOf(5, 6, 7, 8, 9, 10)),
        )
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = Bonus(7, winningNumbers)

        //When
        val machine = LottoDrawingMachine(lottoTickets, winningNumbers, bonusNumber)
        val result = machine.getRankCounts()

        //Then
        assertEquals(1, result[Rank.FIRST])
        assertEquals(1, result[Rank.SECOND])
        assertEquals(1, result[Rank.THIRD])
        assertEquals(1, result[Rank.FOURTH])
        assertEquals(1, result[Rank.FIFTH])
        assertEquals(1, result[Rank.NONE])
    }
}