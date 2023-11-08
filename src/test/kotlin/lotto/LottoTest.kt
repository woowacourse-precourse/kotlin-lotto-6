package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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
    fun `로또 번호가 범위를 벗어나면 예외가 발생한다`() {
        val numbersCases = listOf(
            listOf(0, 1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 46),
            listOf(-10, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 1000)
        )
        numbersCases.forEach { numbers ->
            assertThrows<IllegalArgumentException> {
                Lotto(numbers)
            }
        }
    }
}
