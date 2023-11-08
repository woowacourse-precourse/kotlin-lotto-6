package validator.bonusnumbervalidator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["7,8,9", "", "7,8,9,10,11,12"])
    fun `보너스 번호 숫자가 1자리가 아닐 때 예외를 던지는지`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.appropriateBonusNumber(bonusNumber, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "십", "구"])
    fun `보너스 번호가 숫자가 아닐 때 예외를 던지는지`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.appropriateBonusNumber(bonusNumber, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
