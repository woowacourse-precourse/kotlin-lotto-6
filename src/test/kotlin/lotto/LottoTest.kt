package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.Constants.FIFTH_PLACE
import lotto.Constants.FIRST_PLACE
import lotto.Constants.FOURTH_PLACE
import lotto.Constants.SECOND_PLACE
import lotto.Constants.THIRD_PLACE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `구매한 로또 번호 테스트`() {
        assertSimpleTest {
            val result = Purchase().lottoNum(3000)
            result.forEach { lottoNumbers ->
                assertTrue(lottoNumbers.size == 6)
                assertTrue(lottoNumbers.toSet().size == 6)
                assertTrue(lottoNumbers.all { it in 1..45 })
                assertTrue(lottoNumbers.sorted() == lottoNumbers)
            }
            assertTrue(result.size == 3)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6,${FIRST_PLACE}",
        "1,2,3,4,5,7,${SECOND_PLACE}",
        "1,2,3,4,5,9,${THIRD_PLACE}",
        "1,2,3,4,8,9,${FOURTH_PLACE}",
        "1,2,3,7,8,9,${FIFTH_PLACE}"
    )
    fun `로또 등수 테스트`(arg1: Int, arg2: Int, arg3: Int, arg4: Int, arg5: Int, arg6: Int, place: Int) {
        assertSimpleTest {
            val lotto = listOf(arg1, arg2, arg3, arg4, arg5, arg6)
            val result = Lotto(lotto).isWin(listOf(1, 2, 3, 4, 5, 6), 7)
            assertEquals(place, result)
        }
    }

    @Test
    fun `당첨 통계 테스트`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        assertSimpleTest {
            val lotto = mutableListOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 7),
                listOf(1, 2, 3, 10, 11, 12)
            )
            Statistics(3000).winLotto(lotto, listOf(1, 2, 3, 4, 5, 6), 7)
        }

        System.setOut(System.out)
        val printedOutput = outputStream.toString()

        assertThat(printedOutput).contains(
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
            "6개 일치 (2,000,000,000원) - 1개",
            "총 수익률은 67,666,833.3%입니다."
        )
    }
}