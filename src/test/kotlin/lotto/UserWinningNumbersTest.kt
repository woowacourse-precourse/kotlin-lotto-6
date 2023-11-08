package lotto

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("UserWinningNumbers 테스트")
class UserWinningNumbersTest {

    @Test
    @DisplayName("유효한 번호로 초기화")
    fun `유효한 번호로 초기화`() {
        val userWinningNumbers = UserWinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
    }

    @Test
    @DisplayName("6개 번호가 아닌 경우 예외 발생")
    fun `6개 번호가 아닌 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            UserWinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7), 7)
        }
    }

    @Test
    @DisplayName("중복된 로또 번호 예외 발생")
    fun `중복된 로또 번호 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            UserWinningNumbers(listOf(1, 2, 3, 3, 4, 5), 7)
        }
    }

    @Test
    @DisplayName("로또 번호 범위 벗어날 경우 예외 발생")
    fun `로또 번호 범위 벗어날 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            UserWinningNumbers(listOf(1, 2, 3, 4, 5, 60), 7)
        }
    }

    @Test
    @DisplayName("보너스 번호 중복일 경우 예외 발생")
    fun `보너스 번호 중복일 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            UserWinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    @DisplayName("보너스 번호 범위 벗어날 경우 예외 발생")
    fun `보너스 번호 범위 벗어날 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            UserWinningNumbers(listOf(1, 2, 3, 4, 5, 6), 60)
        }
    }

}