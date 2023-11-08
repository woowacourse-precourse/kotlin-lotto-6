package lotto.model

import lotto.ValidatorError
import org.assertj.core.api.Assertions.assertThatThrownBy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 100, -1, 46])
    fun `값이 로또의 범위를 넘어섰을 때, 오류를 반환한다`(input: Int) {
        assertThatThrownBy { LottoNumber(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(LottoNumber.OUT_OF_RANGE_ERROR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "+1", "asdf", ""])
    fun `숫자가 아닌 문자를 넘겨주었을 때, 오류를 반환한다`(input: String) {
        assertThatThrownBy { LottoNumber(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ValidatorError.NotNumber.message)
    }
}