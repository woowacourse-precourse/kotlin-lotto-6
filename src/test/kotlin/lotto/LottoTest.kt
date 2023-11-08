package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
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

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `toString은 올바른 형식의 문자열을 반환해야 한다`() {
        val numbers = listOf(8, 27, 34, 4, 19, 10)
        val lotto = Lotto(numbers)
        val expectedFormat = "[8, 27, 34, 4, 19, 10]"
        assertEquals(expectedFormat, lotto.toString())
    }

    @Test
    fun `toSet은 로또 번호를 포함하는 집합을 반환해야 한다`() {
        val numbers = listOf(12, 7, 26, 33, 45, 11)
        val lotto = Lotto(numbers)
        val expectedSet = setOf(12, 7, 26, 33, 45, 11)
        assertEquals(expectedSet, lotto.toSet())
    }
}
