package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoProgramTest : NsTest() {

    @Test
    fun `전체 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                run("3000", "1,2,3,4,5,6", "7")
                Assertions.assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 7]",
                    "[1, 2, 3, 10, 11, 12]",
                    "[7, 11, 16, 35, 36, 44]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 1,000,166.7%입니다."
                )
            },
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 10, 11, 12),
            listOf(7, 11, 16, 35, 36, 44)
            )
    }

    @Test
    fun `전체 테스트2`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                run("3000", "1,2,3,4,5,6", "7")
                Assertions.assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 9]",
                    "[1, 2, 3, 10, 11, 12]",
                    "[7, 11, 16, 35, 36, 44]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 50,166.7%입니다."
                )
            },
            listOf(1, 2, 3, 4, 5, 9),
            listOf(1, 2, 3, 10, 11, 12),
            listOf(7, 11, 16, 35, 36, 44)
        )
    }


    override fun runMain() {
        main()
    }

}