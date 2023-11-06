package lotto.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersValidatorTest {
    private val validator = WinningNumbersValidator()

    @Test
    fun `당첨 번호 검증 테스트 - 공백을 입력한 경우`() {
        val winningNumbers = ""
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 숫자가 아닌 다른 형식을 입력한 경우 1`() {
        val winningNumbers = "1,2,3,4, ,5,6"
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 숫자가 아닌 다른 형식을 입력한 경우 2`() {
        val winningNumbers = "1,2,3,4,5,test"
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 6개의 숫자가 아닌 경우 1`() {
        val winningNumbers = "1,2,3,4,5"
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 6개의 숫자가 아닌 경우 2`() {
        val winningNumbers = "1,2,3,4,5,6,7"
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 시작 범위를 벗어난 경우`() {
        val winningNumbers = "0,1,2,3,4,5"
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 끝 범위를 벗어난 경우`() {
        val winningNumbers = "1,2,3,4,5,46"
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @Test
    fun `당첨 번호 검증 테스트 - 당첨 번호가 중복된 경우`() {
        val winningNumbers = "1,2,3,4,5,5"
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }
}