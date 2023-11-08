package lotto.model

import lotto.model.validation.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoAndBonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", " ", "0,", ",0", "2, 3"])
    fun `보너스 번호가 숫자만으로 구성되지 않으면, 예외가 발생한다`(data: String) {
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumber(data)
        }
        Assertions.assertThat(exception.message).isEqualTo(LottoNumber.LOTTO_NUMBER_NOT_DIGIT)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-10", "0", "46"])
    fun `보너스 번호가 1~45의 범위가 아니면, 예외가 발생한다`(data: String) {
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumber(data)
        }
        Assertions.assertThat(exception.message).isEqualTo(LottoNumber.LOTTO_NUMBER_OUT_OF_RANGE)
    }
}