package validator.bonusnumbervalidator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class BonusNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["7,8,9", "", "7,8,9,10,11,12"])
    fun `보너스 번호 숫자가 1자리가 아닐 때 예외를 던지는지`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.isAppropriateBonusNumber(bonusNumber, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "십", "구"])
    fun `보너스 번호가 숫자가 아닐 때 예외를 던지는지`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.isAppropriateBonusNumber(bonusNumber, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @ParameterizedTest
    @MethodSource("generateData")
    fun `보너스 번호 숫자가 로또 번호와 중복되는 수일 때 예외를 던지는지`(bonusNumber: String, lottoNumber: List<Int>) {
        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.isAppropriateBonusNumber(bonusNumber, lottoNumber)
        }
    }

    companion object {
        @JvmStatic
        fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1", listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of("2", listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of("3", listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of("4", listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of("5", listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of("6", listOf(1, 2, 3, 4, 5, 6)),
            )
        }
    }
}
