package lotto.validator.string

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DivideThousandValidatorTest {
    @Test
    fun `숫자형 문자열이 1000의 단위이 아니면 비정상`() {
        val divideThousandValidator = DivideThousandValidator()
        val invalidString = "1200"

        assertThrows<IllegalArgumentException>("문자열 $invalidString 은 숫자여야 합니다") {
            divideThousandValidator.validate(invalidString)
        }
    }
}