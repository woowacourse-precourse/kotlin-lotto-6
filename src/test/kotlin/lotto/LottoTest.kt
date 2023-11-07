package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


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
}
