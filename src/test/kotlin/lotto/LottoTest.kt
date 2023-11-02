package lotto

import lotto.constants.Exception
import lotto.io.input.InputConverter
import lotto.io.input.InputValidator
import lotto.model.Amount
import lotto.model.Lotto
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource


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
    fun `로또 번호의 범위가 1~45를 벗어나면 예외가 발생한다`() {
        assertThatThrownBy { Lotto(listOf(1, 3, 5, 35, 60, 90)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.RANGE.toString())
    }

    @Test
    fun `로또 번호가 조건을 만족하면 예외가 발생하지 않는다`() {
        assertThatCode { Lotto(listOf(1, 3, 5, 10, 15, 42)) }
            .doesNotThrowAnyException()
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


    @Test
    fun `구매 금액이 조건을 만족하면 예외가 발생하지 않는다`() {
        val 구매금액 = "8000"

        assertThatCode {
            InputValidator().checkAmount(구매금액)
            Amount(구매금액.toInt())
        }
            .doesNotThrowAnyException()
    }

    @Test
    fun `입력받은 당첨 번호 문자열을 Lotto 객체로 변환한다`() {
        // given
        val case = "1,4,6,10,15,29"

        // when
        val result = InputConverter().convertLotto(case)

        // then
        assertThat(result)
            .isInstanceOf(Lotto::class.java)
        //TODO("Lotto number까지 비교하는 방법 생각해보기")
    }

    @ParameterizedTest
    @ValueSource(strings = [",1,2,3,4,5,6", "1,2,3,4,5,6,", "1,,2,3,4,5,6"])
    fun `입력받은 당첨 번호의 쉼표가 잘못 입력되면 예외가 발생한다`(numbers: String) {
        assertThatThrownBy { InputValidator().checkWinningLotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.COMMA.toString())
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5 ,6", "1,2,3,4,5a,6"])
    fun `입력받은 당첨 번호에 숫자가 아닌 문자가 포함되면 예외가 발생한다`(numbers: String) {
        assertThatThrownBy { InputValidator().checkWinningLotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.DIGIT.toString())
    }

    @Test
    fun `당첨 번호가 조건을 만족하면 예외가 발생하지 않는다`() {
        assertThatCode {
            InputValidator().checkWinningLotto("1,2,3,4,5,6")
        }
            .doesNotThrowAnyException()
    }

    @ParameterizedTest
    @MethodSource("emptyInputTest")
    fun `입력값이 비어있으면 예외가 발생한다`(execution: () -> Unit) {
        assertThatThrownBy {
            execution.invoke()
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.EMPTY.toString())
    }

    companion object {
        @JvmStatic
        fun emptyInputTest() = listOf(
            Arguments.of({ InputValidator().checkAmount("") }),
            Arguments.of({ InputValidator().checkWinningLotto("") }),
            Arguments.of({ InputValidator().checkBonusNumber("") })
        )
    }
}
