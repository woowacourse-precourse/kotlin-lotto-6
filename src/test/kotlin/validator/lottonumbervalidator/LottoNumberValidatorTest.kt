package validator.lottonumbervalidator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["a,b,c,d,e,f", "1,2,3,4,5,a", "1,a,2,b,3,c"])
    fun `로또 번호가 숫자가 아닐 때 예외를 던지는지`(input: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumberValidator.appropriateLottoNumber(input)
        }
    }
}
