package lotto.domain.lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 45, 20])
    fun `정상적인 객체 생성`(input: Int) {
        // when & then
        assertDoesNotThrow { LottoNumber(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 50])
    fun `범위 초과 예외 처리`(input: Int) {
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoNumber(input) }
            .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}