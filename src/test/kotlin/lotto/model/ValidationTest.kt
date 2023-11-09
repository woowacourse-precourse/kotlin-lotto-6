package lotto.model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["횟수", "1200"])
    fun `로또 구입 금액 입력 에러 메시지 테스트`(input: String) {
        assertThatThrownBy {
            Validation.getPurchaseAmount(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["횟수", "1 2 3", "1,2,3,4,5", "1,2,3,4,5,100", "1,2,3,4,5,5"])
    fun `당첨 번호 입력 에러 메시지 테스트`(input: String) {

        assertThatThrownBy {
            Validation.getAnswerNumber(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["횟수", "100", "1,2"])
    fun `보너스 번호 입력 에러 메시지 테스트`(input: String) {
        assertThatThrownBy {
            Validation.getBonusNum(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }

}