package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또 번호와 당첨번호(+보너스 번호)를 비교해 결과를 반환`() {
        val lottoMachine = LottoMachine("4000")

        val allLotto = listOf(
            listOf(1, 4, 10, 25, 32, 41),
            listOf(2, 8, 17, 19, 24, 31),
            listOf(1, 4, 16, 20, 32, 43),
            listOf(1, 4, 10, 19, 25, 41)
        )
        val winningNumber = listOf(1, 4, 10, 19, 25, 41)
        val bonusNumber = 32

        val result = lottoMachine.calculateMatchResults(allLotto, winningNumber, bonusNumber)

        val expectedResult = listOf(
            Pair(5, true),
            Pair(1, false),
            Pair(2, true),
            Pair(6, false)
        )

        assertEquals(expectedResult, result)
    }

    @Test
    fun `당첨금 enum과 당첨 결과를 비교`() {
        val lottoMachine = LottoMachine()

        val results = listOf(
            Pair(6, false),
            Pair(5, true),
            Pair(3, false),
            Pair(2, true),
            Pair(1, false)
        )

        val exceptedResults = mapOf(
            Jackpot.FIRST to 1,
            Jackpot.SECOND to 1,
            Jackpot.FIFTH to 1,
            null to 2,
        )

        val tallyResults = lottoMachine.tallyResults(results)

        assertEquals(exceptedResults, tallyResults)
    }

    @Test
    fun `당첨 내역 확인`() {
        val lottoMachine = LottoMachine()

        val stats = mapOf(
            Jackpot.FIRST to 1,
            Jackpot.SECOND to 2,
            Jackpot.FIFTH to 1,
            null to 0
        )

        val winningDetails = lottoMachine.getWinningDetails(stats)

        val expectedResult = listOf(
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
            "6개 일치 (2,000,000,000원) - 1개"
        )

        assertEquals(expectedResult, winningDetails)
    }

}