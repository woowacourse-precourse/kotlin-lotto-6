package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoGamePrinterTest : NsTest() {

    @Test
    fun `만들어진 로또 숫자가 적절하게 나오는지에 대한 여부`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                run("5000", "1,2,3,4,5,6", "7")
                Assertions.assertThat(output()).contains(
                    "5개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
        )
    }

    @Test
    fun `당첨 통계 정보가 나오는지에 대한 여부`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            run("5000", "1,2,3,4,5,6", "7")
            Assertions.assertThat(output()).contains(
                "당첨 통계",
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)",
                "총 수익률은"
            )
        }
    }

    override fun runMain() {
        main()
    }
}