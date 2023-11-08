package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCalculatorTest: NsTest() {

    @Test
    fun `로또의 숫자 6개가 모두 일치할 때`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains("6개 일치 (2,000,000,000원) - 1개")
            },
            listOf(1, 2, 3, 4, 5, 6),
        )
    }

    @Test
    fun `로또의 숫자 5개, 보너스 번호가 일치할 때`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개")
            },
            listOf(1, 2, 3, 4, 5, 7),
        )
    }

    @Test
    fun `로또의 숫자 5개 일치할 때`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains("5개 일치 (1,500,000원) - 1개")
            },
            listOf(1, 2, 3, 4, 5, 8),
        )
    }

    @Test
    fun `로또의 숫자 4개 일치할 때`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains("4개 일치 (50,000원) - 1개")
            },
            listOf(1, 2, 3, 4, 8, 9),
        )
    }

    @Test
    fun `로또의 숫자 3개 일치할 때`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains("3개 일치 (5,000원) - 1개")
            },
            listOf(1, 2, 3, 8, 9, 10),
        )
    }

    @Test
    fun `총 수익률이 적절하게 계산되는지 여부`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("2000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains("총 수익률은 2750.0%입니다.")
            },
            listOf(1, 2, 3, 8, 9, 10),
            listOf(1, 2, 3, 4, 8, 9),
        )
    }

    override fun runMain() {
        main()
    }

}