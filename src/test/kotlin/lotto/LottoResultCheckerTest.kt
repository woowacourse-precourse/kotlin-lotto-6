package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoResultCheckerTest {

    private val lottoResultChecker = LottoResultChecker()
    private val winnerNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val inputs = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        Lotto(listOf(1, 2, 3, 4, 5, 7)),
        Lotto(listOf(1, 2, 3, 4, 5, 8)),
        Lotto(listOf(1, 2, 3, 4, 8, 9)),
        Lotto(listOf(1, 2, 3, 8, 9, 10)),
        Lotto(listOf(1, 2, 8, 9, 10, 11))
    )

    @Test
    fun When_6MatchingNumbers_Expect_First() {
        val input = inputs[0]
        val matchingNumbers = input.countSameNumber(winnerNumbers)
        val hasBonusNumber = input.hasBonusNumber(bonusNumber)
        val expected = WinningCriteria.FIRST
        assertEquals(lottoResultChecker.setWinningResult(matchingNumbers, hasBonusNumber), expected)
    }

    @Test
    fun When_5MatchingNumbers_WithBonusNumber_Expect_Second() {
        val input = inputs[1]
        val matchingNumbers = input.countSameNumber(winnerNumbers)
        val hasBonusNumber = input.hasBonusNumber(bonusNumber)
        val expected = WinningCriteria.SECOND
        assertEquals(lottoResultChecker.setWinningResult(matchingNumbers, hasBonusNumber), expected)
    }

    @Test
    fun When_5MatchingNumbers_WithOutBonusNumber_Expect_Third() {
        val input = inputs[2]
        val matchingNumbers = input.countSameNumber(winnerNumbers)
        val hasBonusNumber = input.hasBonusNumber(bonusNumber)
        val expected = WinningCriteria.THIRD
        assertEquals(lottoResultChecker.setWinningResult(matchingNumbers, hasBonusNumber), expected)
    }

    @Test
    fun When_4MatchingNumbers_Expect_Fourth() {
        val input = inputs[3]
        val matchingNumbers = input.countSameNumber(winnerNumbers)
        val hasBonusNumber = input.hasBonusNumber(bonusNumber)
        val expected = WinningCriteria.FOURTH
        assertEquals(lottoResultChecker.setWinningResult(matchingNumbers, hasBonusNumber), expected)
    }

    @Test
    fun When_3MatchingNumbers_Expect_Fifth() {
        val input = inputs[4]
        val matchingNumbers = input.countSameNumber(winnerNumbers)
        val hasBonusNumber = input.hasBonusNumber(bonusNumber)
        val expected = WinningCriteria.FIFTH
        assertEquals(lottoResultChecker.setWinningResult(matchingNumbers, hasBonusNumber), expected)
    }

    @Test
    fun When_2MatchingNumbers_Expect_None() {
        val input = inputs[5]
        val matchingNumbers = input.countSameNumber(winnerNumbers)
        val hasBonusNumber = input.hasBonusNumber(bonusNumber)
        val expected = WinningCriteria.NONE
        assertEquals(lottoResultChecker.setWinningResult(matchingNumbers, hasBonusNumber), expected)
    }

    @Test
    fun When_LottoTickets_Expect_EacnCount_1() {
        val results = lottoResultChecker.compareLottoTicketsWithWinningNumbers(inputs, winnerNumbers, bonusNumber)
        results.forEach{ result ->
            assertEquals(result.value, 1)
        }
    }
}