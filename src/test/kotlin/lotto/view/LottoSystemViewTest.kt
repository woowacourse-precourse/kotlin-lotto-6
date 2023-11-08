import lotto.model.LottoMatchNum
import lotto.model.LottoResult
import lotto.view.LottoSystemView
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class LottoSystemViewTest {
    private val outputContent = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputContent))
    }

    @Test
    fun `로또 당첨 결과 별 당첨 통계 출력 with value1`() {
        var lottoResult = LottoResult()
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(3))
        LottoSystemView().printWinningStatistics(lottoResult)

        val expectedOutput = """
            당첨 통계
            ---
            3개 일치 (5,000원) - 1개
            4개 일치 (50,000원) - 0개
            5개 일치 (1,500,000원) - 0개
            5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
            6개 일치 (2,000,000,000원) - 0개
        """.trimIndent()

        assertEquals(expectedOutput, outputContent.toString().trim())
    }

    @Test
    fun `로또 당첨 결과 별 당첨 통계 출력 with value2`() {
        var lottoResult = LottoResult()
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(3))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(51))
        lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(6))
        LottoSystemView().printWinningStatistics(lottoResult)
        val expectedOutput = """
            당첨 통계
            ---
            3개 일치 (5,000원) - 1개
            4개 일치 (50,000원) - 0개
            5개 일치 (1,500,000원) - 0개
            5개 일치, 보너스 볼 일치 (30,000,000원) - 3개
            6개 일치 (2,000,000,000원) - 1개
        """.trimIndent()

        assertEquals(expectedOutput, outputContent.toString().trim())
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }
}
