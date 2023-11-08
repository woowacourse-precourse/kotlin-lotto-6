package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.view.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OutputViewTest: NsTest() {
    @Test
    fun `생성된 로또 번호 출력 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val purchasedLottoService = PurchasedLottoService(10)
                purchasedLottoService.setPurchsedLottoCollection(listOf(1,2,3,4,5,6), 7)
                val outputView = OutputView()

                outputView.printAllPurchasedLotto(purchasedLottoService.getPurchasedLottoDtoList())
                Assertions.assertThat(output()).contains(
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                )
            },
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
        TODO("Not yet implemented")
    }
}