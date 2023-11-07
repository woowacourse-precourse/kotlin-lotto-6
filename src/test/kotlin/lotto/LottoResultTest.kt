package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {
    private val lottoResult = LottoResult()

    @Test
    fun `당첨 통계 계산`() {
        val testLottoList = listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
        val testLottoNumber = listOf(1, 2, 3, 4, 5, 6)
        val testBonusNumber = 7
        val expectedValue = listOf(2, 4, 1, 1, 0, 0, 0, 0)
        val result = lottoResult.calculateResult(testLottoList, testLottoNumber, testBonusNumber)
        assertEquals(expectedValue, result)
    }

    @Test
    fun `당첨 통계 한 번 계산`() {
        val testLotto = listOf(1, 2, 3, 7, 15, 18)
        val testLottoNumber = listOf(1, 2, 3, 4, 5, 6)
        val testBonusNumber = 7
        val expectedValue = listOf(4, 1)
        val result = lottoResult.calculateResultOnce(testLotto, testLottoNumber, testBonusNumber)
        assertEquals(expectedValue, result)
    }

    @Test
    fun `총 상금 계산`() {
        // 당첨 통계
        val testInput = listOf(0, 0, 0, 1, 1, 0, 0, 0)
        val expectedValue = 55000L
        val calculatePrize = lottoResult.calculateTotalPrize(testInput)
        assertEquals(expectedValue, calculatePrize)
    }
}