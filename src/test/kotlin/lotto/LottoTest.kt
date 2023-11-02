package lotto

import lotto.constants.Exception
import lotto.io.input.InputValidator
import lotto.model.Amount
import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 정렬되어 있지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 4, 3, 5, 6))
        }
    }

    @Test
    fun `구매 금액에 숫자가 아닌 문자가 있으면 예외가 발생한다`() {
        assertThatThrownBy { InputValidator().checkAmount("100a") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.DIGIT.toString())
    }

    @Test
    fun `구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThatThrownBy { Amount(1200) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.DIVISIBLE.toString())
    }
}
