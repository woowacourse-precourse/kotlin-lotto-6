package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class LottoTest {
    private val lotto = Lotto(listOf(1,2,3,4,5,6))
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
    fun `겹치는 숫자가 5개인 경우`() {
        val myNumbers = listOf(1, 2, 3, 4, 5, 7)
        val result = lotto.compareNumber(myNumbers)

        assertEquals(5, result)
    }
    @Test
    fun `겹치는 숫자가 없는 경우`() {
        val myNumbers = listOf(7, 8, 9, 10, 11, 12)
        val result = lotto.compareNumber(myNumbers)

        assertEquals(0, result)
    }
    @ParameterizedTest
    @ValueSource(ints =[ 1, 2])
    fun `로또번호에 보너스 숫자가 있는경우`(input : Int) {
        val result = lotto.compareBonusNumber(input)
        assertTrue(result)
    }

    @ParameterizedTest
    @ValueSource(ints =[ 16, 17])
    fun `로또번호에 보너스 숫자가 없는 경우`(input : Int) {
        val result = lotto.compareBonusNumber(input)
        assertFalse(result)
    }
}
