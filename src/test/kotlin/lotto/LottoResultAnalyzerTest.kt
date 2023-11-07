package lotto

import lotto.model.LottoResultAnalyzer
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoResultAnalyzerTest {

    private val lottoResultAnalyzer = LottoResultAnalyzer()
    private val result = listOf(0, 100, 4)

    init {
        lottoResultAnalyzer.analyzeLottoResults(result)
    }

    @Test
    @DisplayName("발행된 로또와 일치하는 갯수를 가진 결과 리스트를 로또 등수에 맞게 분류")
    fun analyzeLottoResultsTest() {
        val actualValue = lottoResultAnalyzer.analyzedLottoResults
        val expected = listOf(0, 1, 0, 1, 0)
        assertEquals(expected, actualValue)
    }

    @Test
    @DisplayName("로또 수익률을 계산")
    fun calculateProfitRateTest() {
        val purchaseAmount = 5000
        val expected = 601000.00
        lottoResultAnalyzer.calculateProfitRate(purchaseAmount)
        val actualValue = lottoResultAnalyzer.profitRate
        assertEquals(expected, actualValue)
    }
}