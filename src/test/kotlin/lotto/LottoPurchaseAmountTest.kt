package lotto

import lotto.model.isAmountInThousand
import lotto.model.isLessThanThousand
import lotto.model.isLottoNumber
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = ["q", "`", "ㅂ", "", "1000j"])
    fun `로또 구입 금액이 숫자가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.isLottoNumber()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1000", "0", "999"])
    fun `로또 구입 금액이 1000원 보다 적으면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.isLessThanThousand()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1001", "20001", "1110"])
    fun `로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.isAmountInThousand()
        }
    }
}