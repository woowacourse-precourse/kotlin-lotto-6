package lotto.validator.string

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberValidatorTest {
    @Test
    fun `보너스 번호가 숫자가 아닐 경우 예외`() {
        val bonusNumberValidator = BonusNumberValidator(listOf(1, 2, 3, 4, 5, 6))
        val invalidString = "a"

        assertThrows<IllegalArgumentException>("보너스 번호는 숫자여야 합니다.") {
            bonusNumberValidator.validate(invalidString)
        }
    }

    @Test
    fun `보너스 번호가 1 ~ 45 범위가 아닐 경우 예외`() {
        val bonusNumberValidator = BonusNumberValidator(listOf(1, 2, 3, 4, 5, 6))
        val invalidString = "46"

        assertThrows<IllegalArgumentException>("보너스 번호는 1 ~ 45 사이여야 합니다.") {
            bonusNumberValidator.validate(invalidString)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 경우 예외`() {
        val winnerNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumberValidator = BonusNumberValidator(winnerNumbers)
        val invalidString = "1"

        assertThrows<IllegalArgumentException>("보너스 번호 $invalidString 는 당첨 번호 $winnerNumbers 와 중복될 수 없습니다.") {
            bonusNumberValidator.validate(invalidString)
        }
    }
}