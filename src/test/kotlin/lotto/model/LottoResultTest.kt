package lotto.model

import lotto.util.Constants.RANKING_1ST_INDEX
import lotto.util.Constants.RANKING_4ST_INDEX
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {
    private val lottoWinningNumber = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val lottoResult = LottoResult(lottoWinningNumber, bonusNumber)

    @ParameterizedTest
    @DisplayName("로또 랭킹이 올바르게 반환되는지 확인한다.")
    @CsvSource(value = ["1,2,3,4,10,11,${RANKING_4ST_INDEX}", "1,2,3,4,5,6,${RANKING_1ST_INDEX}"], delimiter = ',')
    fun calculateRankingTest(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int, expected: Int) {
        val validation = lottoResult.calculateRanking(listOf(num1, num2, num3, num4, num5, num6))
        assertThat(validation).isEqualTo(expected)
    }
}