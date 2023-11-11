package lotto.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberValidatorTest {
    private val validator = BonusNumberValidator()
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

    @ParameterizedTest
    @ValueSource(strings = ["", "test", " "])
    fun `보너스 번호 검증 테스트 - 숫자가 아닌 형식을 입력한 경우`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "46", "100000"])
    fun `보너스 번호 검증 테스트 - 범위를 벗어난 경우`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `보너스 번호 검증 테스트 - 당첨 번호와 중복된 경우`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }
}