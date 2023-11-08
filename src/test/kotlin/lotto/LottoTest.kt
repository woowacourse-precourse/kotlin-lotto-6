package lotto

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

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호에 동일한 숫자가 있을 경우 true를 반환한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)

        // When
        val result = lotto.contains(1)

        // Then
        assertTrue(result)
    }

    @Test
    fun `로또 번호에 동일한 숫자가 있지 않을 경우 false를 반환한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)

        // When
        val result = lotto.contains(7)

        // Then
        assertFalse(result)
    }
}
