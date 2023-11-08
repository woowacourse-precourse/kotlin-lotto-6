package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MachineTest : NsTest() {
    @Test
    fun `2등 보너스 + 5등 당첨 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                run("10000", "7,8,9,10,11,12", "6")
                assertThat(output()).contains(
                    "10개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 13]",
                    "[6, 7, 8, 9, 10, 11]",
                    "[10, 11, 12, 13, 14, 15]",
                    "[2, 7, 10, 15, 20, 25]",
                    "[3, 8, 13, 18, 23, 28]",
                    "[4, 9, 14, 19, 24, 29]",
                    "[5, 10, 15, 20, 25, 30]",
                    "[1, 6, 11, 16, 21, 31]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 300050.0%입니다."
                )
            },
            listOf(1, 2, 3, 4, 5, 13),
            listOf(6, 7, 8, 9, 10, 11),
            listOf(10, 11, 12, 13, 14, 15),
            listOf(2, 7, 10, 15, 20, 25),
            listOf(3, 8, 13, 18, 23, 28),
            listOf(4, 9, 14, 19, 24, 29),
            listOf(5, 10, 15, 20, 25, 30),
            listOf(1, 6, 11, 16, 21, 31)
        )
    }

    override fun runMain() {
        main()
    }
}