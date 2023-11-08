package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Printer 테스트")
class PrinterTest : NsTest() {

    private val printer = Printer()
    private lateinit var lotto: List<Lotto>
    private lateinit var types: List<LottoWinType>
    private lateinit var yield: String

    @BeforeEach
    fun setting() {
        lotto = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18)),
            Lotto(listOf(19, 20, 21, 22, 23, 24)),
            Lotto(listOf(25, 26, 27, 28, 29, 30))
        )

        types = listOf(LottoWinType.THREE_MATCH, LottoWinType.FOUR_MATCH, LottoWinType.FIVE_MATCH_WITH_BONUS)
        yield = "1000.0%"
    }

    @Test
    fun `구입금액을 입력해 주세요 안내 문구 출력`() {
        printer.printEnterPurchaseAnnouncement()
        Assertions.assertThat(output()).contains(Message.ENTER_PURCHASE)
    }

    @Test
    fun `N개를 구매했습니다 안내 문구 출력`() {
        printer.printBuyNPiecesAnnouncement(5)
        Assertions.assertThat(output()).contains(Message.BOUGHT_N_PIECES)
    }

    @Test
    fun `당첨 번호를 입력해 주세요 안내 문구 출력`() {
        printer.printEnterUserPickNumbersAnnouncement()
        Assertions.assertThat(output()).contains(Message.ENTER_USER_PICK_NUMBERS)
    }

    @Test
    fun `보너스 번호를 입력해 주세요 안내 문구 출력`() {
        printer.printEnterBonusNumberAnnouncement()
        Assertions.assertThat(output()).contains(Message.ENTER_BONUS_NUMBER)
    }

    @Test
    fun `당첨 통계 안내 문구 출력`() {
        printer.printWinningStatisticsAnnouncement()
        Assertions.assertThat(output()).contains(Message.WINNING_STATISTICS)
    }

    @Test
    fun `콤마 안내 문구 출력`() {
        printer.printCommaAnnouncement()
        Assertions.assertThat(output()).contains(Message.COMMA)
    }

    @Test
    fun `구매 복권 출력하기`() {
        printer.printRandomLottoNumbers(lotto)
        Assertions.assertThat(output()).contains("[1, 2, 3, 4, 5, 6]\n")
            .contains("[7, 8, 9, 10, 11, 12]\n")
            .contains("[13, 14, 15, 16, 17, 18]\n")
            .contains("[19, 20, 21, 22, 23, 24]\n")
            .contains("[25, 26, 27, 28, 29, 30]")
    }

    @Test
    fun `당첨 통계 출력하기`() {
        printer.printWinningStatistics(types, yield)
        Assertions.assertThat(output()).contains(
            "3개 일치 (5,000원) - 1개\n" +
                    "4개 일치 (50,000원) - 1개\n" +
                    "5개 일치 (1,500,000원) - 0개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                    "6개 일치 (2,000,000,000원) - 0개\n" +
                    "총 수익률은 1000.0%입니다."
        )
    }

    override fun runMain() {
        TODO("Not yet implemented")
    }
}