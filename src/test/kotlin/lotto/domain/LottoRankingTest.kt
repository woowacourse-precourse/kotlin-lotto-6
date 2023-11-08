package lotto.domain

import lotto.model.Lotto
import lotto.model.LottoRanking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoRankingTest {
    @Test
    fun `당첨 여부를 올바르게 구한다(4등 예시)`() {
        val winningLottoNumbers = Lotto(listOf(1,2,3,4,5,6))
        val bonusNumber = 7
        val userLottoNumberList = listOf(
            Lotto(listOf(1,2,3,4,8,9)),
            Lotto(listOf(3,4,5,6,7,8)),
            )
        LottoRanking.calculateMatchingLottoRank(winningLottoNumbers, bonusNumber, userLottoNumberList)
        val result = LottoRanking.FORTH_RANK.userLottoRankCnt
        assertEquals(result, 2)
    }

    @Test
    fun `당첨 여부를 올바르게 구한다(2등 예시)`() {
        val winningLottoNumbers = Lotto(listOf(1,2,3,4,5,6))
        val bonusNumber = 7
        val userLottoNumberList = listOf(
            Lotto(listOf(1,2,3,4,5,7)),
            Lotto(listOf(11,12,13,14,15,16)),
        )
        LottoRanking.calculateMatchingLottoRank(winningLottoNumbers, bonusNumber, userLottoNumberList)
        val result = LottoRanking.SECOND_RANK.userLottoRankCnt
        assertEquals(result, 1)
    }
}