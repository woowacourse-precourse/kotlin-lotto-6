package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import validation.ValidationManager

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
    fun `로또 구입 금액이 1000으로 나누어 안떨어지면 예외가 발생한다`() {
        val lottoPurchaseAmount = 1001
        assertThrows<IllegalArgumentException> {
            ValidationManager().apply {
                lottoPurchaseAmount.modulusLottoPrice()
            }
        }
    }

    @Test
    fun `로또 구입 금액이 0보다 작으면 예외가 발생한다`() {
        val lottoPurchaseAmount = -10000
        assertThrows<IllegalArgumentException> {
            ValidationManager().apply {
                lottoPurchaseAmount.lessThanZero()
            }
        }
    }

    @Test
    fun `로또 숫자가 올바르지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ValidationManager().apply {
                listOf(1, 2, 3, 4, 5, 46).forEach { number ->
                    number.validLottoNumber()
                }
            }
        }
    }

    @Test
    fun `당첨 번호의 개수가 일치하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ValidationManager().apply {
                arrayListOf(1, 2, 3, 4, 5).isCorrectLottoCount()
            }
        }
    }

    @Test
    fun `당첨 번호에 보너스 번호가 포함되어 있다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val bonusNumber = 1
            ValidationManager().apply {
                arrayListOf(1, 2, 3, 4, 5, 6).containBonusNumber(bonusNumber)
            }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
