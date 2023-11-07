package lotto.model

import lotto.model.LottoResultAnalyzer
import lotto.util.Constants.MATCH_FIVE
import lotto.util.Constants.MATCH_FIVE_BONUS
import lotto.util.Constants.MATCH_FOUR
import lotto.util.Constants.MATCH_SIX
import lotto.util.Constants.MATCH_THREE
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoResultAnalyzerTest {

    private val lottoResultAnalyzer = LottoResultAnalyzer()
    private val result = listOf(0,3,4,4,5,6,100)

    init {
    }

    @Test
    @DisplayName("발행된 로또와 일치하는 갯수를 가진 결과 리스트를 로또 등수에 맞게 분류")
    fun analyzeLottoResultsTest() {
        lottoResultAnalyzer.analyzeLottoResults(result)

        val actualValue = lottoResultAnalyzer.analyzedLottoResults
        val expected = listOf(1, 2, 1, 1, 1)
        assertEquals(actualValue,expected)
    }

    @Test
    @DisplayName("로또 수익률을 계산")
    fun calculateProfitRateTest() {
        lottoResultAnalyzer.analyzeLottoResults(result)

        val purchaseAmount = 5000
        val expected:String = "40632100.0"
        lottoResultAnalyzer.calculateProfitRate(purchaseAmount)
        val actualValue = lottoResultAnalyzer.profitRate
        assertEquals(actualValue,expected)
    }
}