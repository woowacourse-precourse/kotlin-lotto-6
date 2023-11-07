package lotto.repository

import lotto.data.model.LottoWinningNumber
import lotto.data.repository.LottoRepositoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class LottoRepositoryImplTest {

    private val lottoRepository = LottoRepositoryImpl()

    @Test
    fun `GenerateRandomLotto 메서드로 로또가 정상적으로 생성되었는지 확인`() {

        val userLottoState = lottoRepository.generateRandomLotto(10)

        assertEquals(10, userLottoState.lottoTickets.size)
    }

    @Test
    fun `CheckStatistics 메서드로 수익률이 정상 반영되었는지 확인`() {

        val lottoWinningNumber = LottoWinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)

        lottoRepository.generateRandomLotto(10)

        val updatedUserLottoState = lottoRepository.checkStatistics(lottoWinningNumber)

        assertFalse(updatedUserLottoState.totalPrizeRate < 0.0)
    }
}
