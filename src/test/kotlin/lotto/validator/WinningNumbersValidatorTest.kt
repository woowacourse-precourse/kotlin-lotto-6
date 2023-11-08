package lotto.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersValidatorTest {
    private val validator = WinningNumbersValidator()

    @ParameterizedTest
    @ValueSource(strings = ["", "1.2.3.4.5.6", " , , , , , ", "일,이,삼,사,오,육"])
    fun `당첨 번호 검증 테스트 - 숫자가 아닌 형식을 입력한 경우`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3"])
    fun `당첨 번호 검증 테스트 - 6개의 숫자가 아닌 경우`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0,1,2,3,4,5", "1,2,3,4,5,46"])
    fun `당첨 번호 검증 테스트 - 범위를 벗어난 경우`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5", "1,1,2,3,4,5"])
    fun `당첨 번호 검증 테스트 - 당첨 번호가 중복된 경우`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validator.validate(winningNumbers) }.also { exception ->
            assertThat(exception.message).contains("[ERROR]")
        }
    }
}