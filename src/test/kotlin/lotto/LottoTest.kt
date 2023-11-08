package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
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

    @Test
    fun `두 로또 티켓이 완전히 일치할 경우 6을 반환한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto1 = Lotto(numbers)
        val lotto2 = Lotto(numbers)

        // When
        val matchCount = lotto1.match(lotto2)

        // Then
        assertEquals(6, matchCount)
    }

    @Test
    fun `두 로또 티켓이 모두 일치하지 않을 경우 0을 반환한다`() {
        // Given
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(7, 8, 9, 10, 11, 12))

        // When
        val matchCount = lotto1.match(lotto2)

        // Then
        assertEquals(0, matchCount)
    }

    @Test
    fun `보너스 번호가 일치할 경우 true를 반환한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        val bonusNumber = 1

        // When
        val matchBonus = lotto.matchBonus(bonusNumber)

        // Then
        assertTrue(matchBonus)
    }

    @Test
    fun `보너스 번호가 일치하지 않을 경우 false를 반환한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        val bonusNumber = 7

        // When
        val matchBonus = lotto.matchBonus(bonusNumber)

        // Then
        assertFalse(matchBonus)
    }
}
