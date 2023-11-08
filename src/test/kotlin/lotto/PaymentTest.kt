package lotto

import lotto.model.Payment
import lotto.model.validator.PaymentValidator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class PaymentTest {

    @ParameterizedTest
    @ValueSource(strings = ["-1", "+1", "hjk", "!"])
    fun `구입 금액이 문자열일 때, 오류를 반환한다`(input: String) {
        assertThatThrownBy {
            Payment.from(input, 1000)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @EmptySource
    fun `구입 금액이 빈 값일 때, 오류를 반환한다`(input: String) {
        assertThatThrownBy {
            Payment.from(input, 1000)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "100", "1001", "10 "])
    fun `구입 금액이 1000원 단위가 아닐 때, 오류를 반환한다`(input: String) {
        assertThatThrownBy {
            Payment.from(input, 1000)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `구입 금액이 8000원일 때, 로또 구매 개수가 8개이다`() {
        assertThat(Payment.from("8000", 1000).purchase).isEqualTo(8)
    }

    @ParameterizedTest
    @ValueSource(strings = ["100001", "999999999999999999999999999999"])
    fun `구입 금액이 10만원 이상일 때, 오류를 반환한다`(input: String) {
        assertThatThrownBy {
            Payment.from(input, 1)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PaymentValidator.OVERFLOW_ERROR)
    }
}