package lotto.validator.string

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersValidatorTest {
    @Test
    fun `당첨 번호가 ,로 구분되지 않을 경우 예외`() {
        val winningNumbersValidator = WinningNumbersValidator()
        val invalidString = "1 2 3 4 5 6"

        assertThrows<IllegalArgumentException>("쉼표(,)로 숫자를 구분해주세요.") {
            winningNumbersValidator.validate(invalidString)
        }
    }

    @Test
    fun `당첨 번호가 6개가 아닐 경우 예외`() {
        val winningNumbersValidator = WinningNumbersValidator()
        val invalidString = "1, 2, 3, 4, 5"

        assertThrows<IllegalArgumentException>("당첨 번호는 6개여야 합니다.") {
            winningNumbersValidator.validate(invalidString)
        }
    }

    @Test
    fun `당첨 번호가 숫자가 아닐 경우 예외`() {
        val winningNumbersValidator = WinningNumbersValidator()
        val invalidString = "1, 2, 3, 4, 5, a"

        assertThrows<IllegalArgumentException>("당첨 번호는 숫자여야 합니다.") {
            winningNumbersValidator.validate(invalidString)
        }
    }

    @Test
    fun `당첨 번호가 1 ~ 45 사이의 숫자가 아닐 경우 예외`() {
        val winningNumbersValidator = WinningNumbersValidator()
        val invalidString = "1, 2, 3, 4, 5, 46"

        assertThrows<IllegalArgumentException>("당첨 번호는 1 ~ 45 사이여야 합니다.") {
            winningNumbersValidator.validate(invalidString)
        }
    }

    @Test
    fun `당첨 번호가 중복될 경우 예외`() {
        val winningNumbersValidator = WinningNumbersValidator()
        val invalidString = "1, 2, 3, 4, 5, 5"

        assertThrows<IllegalArgumentException>("당첨 번호는 중복될 수 없습니다.") {
            winningNumbersValidator.validate(invalidString)
        }
    }
}