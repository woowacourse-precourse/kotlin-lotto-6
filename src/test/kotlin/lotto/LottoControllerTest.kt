package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyList
import org.mockito.Mockito.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class LottoControllerTest {

    @Test
    fun `구매 금액이 3000원일 때 정확한 로또 티켓이 생성되는지 확인한다`() {
        val lottoViewMock = mock(LottoView::class.java)
        val lottoMock = mock(Lotto::class.java)
        val lottoController = LottoController(lottoViewMock, lottoMock)
        val purchaseAmount = 3000

        `when`(lottoMock.generateLottoNumbers()).thenReturn(listOf(1, 2, 3, 4, 5, 6))

        val result = lottoController.generateLottoTickets(purchaseAmount)

        assertEquals(3, result.size)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result[0].numbers)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result[1].numbers)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result[2].numbers)
    }

    @Test
    fun `구매 금액이 0일 때 로또티켓이 빈 리스트가 반환되는지 확인한다`() {
        val lottoViewMock = mock(LottoView::class.java)
        val lottoMock = mock(Lotto::class.java)
        val lottoController = LottoController(lottoViewMock, lottoMock)
        val purchaseAmount = 0

        val result = lottoController.generateLottoTickets(purchaseAmount)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `보너스번호 호출 시 뷰의 메서드가 올바르게 호출되는지 확인한다`() {
        val lottoViewMock = mock(LottoView::class.java)
        val lottoMock = mock(Lotto::class.java)
        val lottoController = LottoController(lottoViewMock, lottoMock)

        lottoController.getWinningNumbersAndBonus()

        verify(lottoViewMock).getWinningNumbersFromUser()
        verify(lottoViewMock).getBonusNumberFromUser(anyList())
    }

    @Test
    fun `당첨번호가 정확한 횟수로 반환되는지 확인한다`() {
        val lottoViewMock = mock(LottoView::class.java)
        val lottoMock = mock(Lotto::class.java)
        val lottoController = LottoController(lottoViewMock, lottoMock)

        val matchCounts = listOf(3, 3, 3, 4, 4, 4, 4, 1, 2, 1, 6)

        val result = lottoController.calculateWinnings(matchCounts)

        assertEquals(3, result[LottoRank.FIFTH])
        assertEquals(4, result[LottoRank.FOURTH])
        assertEquals(null, result[LottoRank.THIRD])
        assertEquals(null, result[LottoRank.SECOND])
        assertEquals(1, result[LottoRank.FIRST])
    }

    @Test
    fun `당첨번호가 빈 리스트가 들어왔을 때 빈 맵이 반환되는지 확인한다`() {
        val lottoViewMock = mock(LottoView::class.java)
        val lottoMock = mock(Lotto::class.java)
        val lottoController = LottoController(lottoViewMock, lottoMock)

        val matchCounts = emptyList<Int>()

        val result = lottoController.calculateWinnings(matchCounts)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `총수익률이 정확하게 출력 되는지 확인한다`() {
        val lottoViewMock = mock(LottoView::class.java)
        val lottoMock = mock(Lotto::class.java)
        val lottoController = LottoController(lottoViewMock, lottoMock)

        val winnings = mapOf(
                LottoRank.FIRST to 0,
                LottoRank.SECOND to 0,
                LottoRank.THIRD to 0,
                LottoRank.FOURTH to 0,
                LottoRank.FIFTH to 1
        )

        val purchaseAmount = 8000

        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        lottoController.calculateTotalProfitRate(winnings, purchaseAmount)

        System.setOut(System.out)

        val expectedOutput = (
                "\n3개 일치 (5,000원) - 1개" +
                        "\n4개 일치 (50,000원) - 0개" +
                        "\n5개 일치 (1,500,000원) - 0개" +
                        "\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" +
                        "\n6개 일치 (2,000,000,000원) - 0개" +
                        "\n총 수익률은 62.5%입니다.").trimIndent()

        assertEquals(expectedOutput, outContent.toString().trim())
    }


}