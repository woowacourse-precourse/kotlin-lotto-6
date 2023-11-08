package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest

class LottoCorrectTest : NsTest() {
    @Test
    fun `여섯자리의 번호 정답`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "6개 일치 (2,000,000,000원) - 1개",
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
        )
    }

    @Test
    fun `다섯자리의 번호와 보너스 번호 정답`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                )
            },
            listOf(1, 2, 3, 4, 5, 7),
        )
    }

    @Test
    fun `다섯자리의 번호 정답`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "5개 일치 (1,500,000원) - 1개",
                )
            },
            listOf(1, 2, 3, 4, 5, 8),
        )
    }

    @Test
    fun `네자리의 번호 정답`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "4개 일치 (50,000원) - 1개",
                )
            },
            listOf(1, 2, 3, 4, 9, 8),
        )
    }

    @Test
    fun `세자리의 번호 정답`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,7,8,9", "10")
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 1개",
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
        )
    }

    @Test
    fun `총 수익률이 정상적으로 계산되고 출력되는지 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,8,9", "10")
                assertThat(output()).contains(
                    "총 수익률은 5000.0%입니다.",
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
        )
    }
    override fun runMain() {
        main()
    }
}