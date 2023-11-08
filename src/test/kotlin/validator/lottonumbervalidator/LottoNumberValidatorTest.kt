package validator.lottonumbervalidator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["a,b,c,d,e,f", "1,2,3,4,5,a", "1,a,2,b,3,c"])
    fun `로또 번호가 숫자가 아닐 때 예외를 던지는지`(input: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumberValidator.isAppropriateLottoNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7", "12,24,38"])
    fun `로또 번호 숫자가 6자리가 아닐 때 예외를 던지는지`(input: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumberValidator.isAppropriateLottoNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,1,1,1,1,1", "1,2,3,4,5,5", "1,2,3,1,2,3"])
    fun `로또 번호 숫자들이 전부 다른 숫자가 아닐 때 예외를 던지는지`(input: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumberValidator.isAppropriateLottoNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,46", "-1,2,3,4,5,6", "-1,-2,-3,-4,-5,-6"])
    fun `로또 번호 숫자 범위가 1~45가 아닐 때 예외를 던지는지`(input: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumberValidator.isAppropriateLottoNumber(input)
        }
    }
}
