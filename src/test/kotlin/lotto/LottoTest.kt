package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


@DisplayName("Lotto 테스트")
class LottoTest {

    @Test
    @DisplayName("유효한 numbers로 초기화")
    fun `유효한 numbers로 초기화`() {
        val lotto = Lotto(numbers = listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    @DisplayName("numbers의 크기가 6이 아니면 예외 발생")
    fun `numbers의 크기가 6이 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers = listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    @DisplayName("numbers에 중복된 숫자가 있으면 예외 발생")
    fun `numbers에 중복된 숫자가 있으면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers = listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    @DisplayName("numbers가 유효한 범위를 벗어나면 예외 발생")
    fun `numbers가 유효한 범위를 벗어나면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers = listOf(1, 2, 3, 4, 5, 50))
        }
    }

    @Test
    @DisplayName("numbers가 오름차순이 아니면 예외 발생")
    fun `numbers가 오름차순이 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers = listOf(1, 3, 2, 4, 5, 6))
        }
    }

    @Test
    @DisplayName("formatNumbers 함수가 올바른 형식의 문자열 반환")
    fun `formatNumbers 함수가 올바른 형식의 문자열 반환`() {
        val lotto = Lotto(numbers = listOf(1, 2, 3, 4, 5, 6))
        val formattedNumbers = lotto.formatNumbers()
        assertEquals(formattedNumbers, "[1, 2, 3, 4, 5, 6]")
    }

    @Test
    @DisplayName("checkMatchWinCount 함수가 올바른 LottoResult 반환")
    fun `checkMatchWinCount 함수가 올바른 LottoResult 반환`() {
        val lotto = Lotto(numbers = listOf(1, 2, 3, 4, 5, 6))
        val userWinningNumbers = UserWinningNumbers(
            userPickNumbers = listOf(1, 2, 3, 4, 5, 7),
            bonusNumber = 10
        )
        val result = lotto.checkMatchWinCount(userWinningNumbers)
        assertEquals(result.winningCount, 5)
        assertEquals(result.bonusJudge, false)
    }

}