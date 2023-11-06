package lotto.view

import camp.nextstep.edu.missionutils.test.Assertions
import lotto.domain.Lotto
import lotto.domain.Lottos
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {
    private val output = Output()
    private val originalOut = System.out
    private val outContent = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `printLottos 메서드 사용시 lottos에 포함된 Lotto의 toString()을 출력`() {
        //given
        val lottos = Lottos(0)
        lottos.getLottos().add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val result = "1개를 구매했습니다.\r\n[1, 2, 3, 4, 5, 6]\r\n"

        //when
        output.printLottos(lottos)

        //then
        val actualOutput = outContent.toString()
        assertEquals(result, actualOutput)
    }

    @Test
    fun `printLottoRankResult 메서드 사용시 `() {
        //given
        val lottos = Lottos(0)
        lottos.getLottos().add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val result = "당첨 통계\r\n" +
                "---\r\n" +
                "3개 일치 (5,000원) - 0개\r\n" +
                "4개 일치 (50,000원) - 0개\r\n" +
                "5개 일치 (1,500,000원) - 0개\r\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\r\n" +
                "6개 일치 (2,000,000,000원) - 1개\r\n"

        //when
        output.printLottoRankResult(lottos.getLottoRanks(listOf(1,2,3,4,5,6),7))

        //then
        val actualOutput = outContent.toString()
        assertEquals(result, actualOutput)
    }

    @Test
    fun `printGrossProfit 메서드 사용시 수익률을 적용해 grossProfitMessage 출력`() {
        //given
        val profit = 133.3
        val result = "총 수익률은 133.3%입니다.\r\n"

        //when
        output.printGrossProfit(profit)

        //then
        val actualOutput = outContent.toString()
        assertEquals(result, actualOutput)
    }

}