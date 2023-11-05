package lotto.model

import lotto.util.Constants.RANKING_4ST_INDEX
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {
    private val lottoWinningNumber = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val lottoResult = LottoResult(lottoWinningNumber, bonusNumber)

    @Test
    @DisplayName("로또 랭킹이 올바르게 반환되는지 확인한다.")
    fun calculateRankingTest() {
        val input = listOf(1, 2, 3, 4, 10, 11)
        val validation = lottoResult.calculateRanking(input)
        val result = RANKING_4ST_INDEX
        assertThat(validation).isEqualTo(result)
    }
}