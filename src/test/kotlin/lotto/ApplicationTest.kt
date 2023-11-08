package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `기능 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 62.5%입니다."
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호 확인 테스트1`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))
        val result = countInWinningNumber(winningNumber, lotto)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `당첨 번호 일치 개수 확인 테스트`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val lottos = mutableListOf(lotto1, lotto2)
        val result = compareWinningNumber(winningNumber, lottos, bonusNumber)
        val expected = listOf(0, 0, 0, 0, 0, 0, 1, 1)
        assertThat(result).isEqualTo(expected)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
