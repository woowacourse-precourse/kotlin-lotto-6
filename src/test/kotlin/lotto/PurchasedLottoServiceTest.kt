package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.dto.CostDto
import lotto.view.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PurchasedLottoServiceTest: NsTest() {

    @Test
    fun `수익 통계 출력 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                val purchasedLottoService = PurchasedLottoService(8)
                purchasedLottoService.setPurchsedLottoCollection(listOf(1, 2, 3, 4, 5, 6), 7)
                val outputView = OutputView()

                outputView.printWinningResult(purchasedLottoService.getWinStatics())
                outputView.printRateOfReturn(purchasedLottoService.calculateRateOfReturn(CostDto(8000)))
                Assertions.assertThat(output()).contains(
                    "총 수익률은 62.5%입니다."
                )
            },
            listOf(1, 3, 5, 14, 22, 45),
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45),
        )
    }

    @Test
    fun `통계 출력 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                val purchasedLottoService = PurchasedLottoService(10)
                purchasedLottoService.setPurchsedLottoCollection(listOf(1, 3, 5, 14, 22, 45), 7)
                val outputView = OutputView()

                outputView.printWinningResult(purchasedLottoService.getWinStatics())

                Assertions.assertThat(output()).contains(
                    "당첨 통계",
                    "---",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 2개"
                )
            },
            listOf(1, 3, 5, 14, 22, 45),
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    override fun runMain() {

    }
}