package lotto.validator.string

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumericValidatorTest {
    @Test
    fun `숫자형 문자열이 아니면 예외`() {
        val numericValidator = NumericValidator()
        val invalidString = "1a2"

        assertThrows<IllegalArgumentException>("문자열 $invalidString 은 숫자여야 합니다") {
            numericValidator.validate(invalidString)
        }
    }
}