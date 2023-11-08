package lotto.view

import lotto.model.Lotto
import lotto.model.WinningRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream


class OutputViewTest {
    private lateinit var standardOut: PrintStream
    private lateinit var captor: OutputStream

    fun output(): String {
        return captor.toString().trim { it <= ' ' }
    }

    @BeforeEach
    fun init() {
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    @AfterEach
    fun printOutput() {
        System.setOut(standardOut)
        println(output())
    }

    @Test
    fun `로또 여러 개를 출력한다`() {
        val lottoes =
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(6, 7, 8, 9, 10, 11)),
                Lotto(listOf(11, 12, 13, 14, 15, 16))
            )
        OutputView.printLottoes(lottoes)
        assertThat(output()).contains(
            "[1, 2, 3, 4, 5, 6]",
            "[6, 7, 8, 9, 10, 11]",
            "[11, 12, 13, 14, 15, 16]"
        )
    }

    @Test
    fun `로또 갯수를 출력한다`() {
        val countOfPurchasedLotto = 3
        OutputView.printCountOfPurchasedLotto(countOfPurchasedLotto)
        assertThat(output()).contains("3개를 구매했습니다.")
    }

    @Test
    fun `당첨 통계를 출력한다`() {
        val winningStatistic = HashMap<WinningRank, Int>()
        winningStatistic[WinningRank.FIFTH] = 1
        winningStatistic[WinningRank.SECOND] = 3
        val earningsRate = 83f
        OutputView.printWinningStatistics(winningStatistic, earningsRate)
        assertThat(output()).contains(
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 3개",
            "6개 일치 (2,000,000,000원) - 0개",
            "총 수익률은 83.0%입니다."
        )
    }
}