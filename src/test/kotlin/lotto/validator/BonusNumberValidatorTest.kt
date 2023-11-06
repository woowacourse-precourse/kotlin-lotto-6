package lotto.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberValidatorTest {
    private val validator = BonusNumberValidator()
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun `당첨 번호 검증 테스트 - 공백을 입력한 경우`() {
        val bonusNumber = ""
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 숫자가 아닌 형식을 입력한 경우`() {
        val bonusNumber = "test"
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 시작 범위를 벗어난 경우`() {
        val bonusNumber = "0"
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 끝 범위를 벗어난 경우`() {
        val bonusNumber = "46"
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 당첨 번호와 중복된 경우`() {
        val bonusNumber = "1"
        assertThrows<IllegalArgumentException> { validator.validate(bonusNumber, winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }
}