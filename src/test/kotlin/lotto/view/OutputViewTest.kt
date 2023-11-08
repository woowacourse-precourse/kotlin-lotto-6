package lotto.view

import lotto.Constants.OUTPUT_FIVE_MATCH_MESSAGE
import lotto.Constants.OUTPUT_FIVE_WITH_BONUS_MATCH_MESSAGE
import lotto.Constants.OUTPUT_FOUR_MATCH_MESSAGE
import lotto.Constants.OUTPUT_PROFIT_PERCENTAGE_MESSAGE
import lotto.Constants.OUTPUT_PURCHASE_COUNT_MESSAGE
import lotto.Constants.OUTPUT_SIX_MATCH_MESSAGE
import lotto.Constants.OUTPUT_THREE_MATCH_MESSAGE
import lotto.Constants.OUTPUT_WINNING_STATISTICS_MESSAGE
import lotto.model.LottoRank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val outputStream = ByteArrayOutputStream()
    val outputView = OutputView()
    @Test
    fun `outputPurchaseCountMessage 메서드 테스트`() {
        val ticket = 5 // 예상 티켓 개수
        val expectedOutput = "\n" + String.format(OUTPUT_PURCHASE_COUNT_MESSAGE, ticket) + "\n"
        System.setOut(PrintStream(outputStream))
        outputView.ticketCountMessage(ticket)
        System.setOut(System.out)
        assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun `outputWinningStatisticsMessage 메서드 테스트`() {
        val lottoThreeMatch = LottoRank.THREE_MATCH
        val lottoFourMatch = LottoRank.FOUR_MATCH
        val lottoFiveMatch = LottoRank.FIVE_MATCH
        val lottoFiveWithBonusMatch = LottoRank.FIVE_MATCH_WITH_BONUS
        val lottoSixMatch = LottoRank.SIX_MATCH
        val expectedOutput = "\n" + OUTPUT_WINNING_STATISTICS_MESSAGE + "\n---" +
                "\n" + String.format(OUTPUT_THREE_MATCH_MESSAGE, lottoThreeMatch.getCount()) +
                "\n" + String.format(OUTPUT_FOUR_MATCH_MESSAGE, lottoFourMatch.getCount()) +
                "\n" + String.format(OUTPUT_FIVE_MATCH_MESSAGE, lottoFiveMatch.getCount()) +
                "\n" + String.format(OUTPUT_FIVE_WITH_BONUS_MATCH_MESSAGE, lottoFiveWithBonusMatch.getCount()) +
                "\n" + String.format(OUTPUT_SIX_MATCH_MESSAGE, lottoSixMatch.getCount())
        System.setOut(PrintStream(outputStream))
        outputView.winningStatisticsMessage()
        System.setOut(System.out)
    }

    @Test
    fun `outputProfitPercentageMessage 메서드 테스트`() {
        val outputView = OutputView()
        val profitPercentage = 0.5 // 예상 수익률
        val expectedOutput = String.format(OUTPUT_PROFIT_PERCENTAGE_MESSAGE, profitPercentage) + "\n"
        System.setOut(PrintStream(outputStream))
        outputView.profitPercentageMessage(profitPercentage)
        System.setOut(System.out)
        assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun `outputRandomLottoList 메서드 테스트`() {
        val outputView = OutputView()
        val lottoList = mutableMapOf(
            1 to listOf(1, 2, 3, 4, 5, 6),
            2 to listOf(7, 8, 9, 10, 11, 12)
        )
        val expectedOutput = """
            [1, 2, 3, 4, 5, 6]
            [7, 8, 9, 10, 11, 12]
        """.trimIndent()
        System.setOut(PrintStream(outputStream))
        outputView.randomLottoLists(lottoList)
        System.setOut(System.out)
        val actualOutput = outputStream.toString().trim()
        assertEquals(expectedOutput, actualOutput)
    }

}