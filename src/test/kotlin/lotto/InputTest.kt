package lotto

import lotto.constants.Exception
import lotto.io.input.InputConverter
import lotto.io.input.InputValidator
import lotto.model.PurchaseInfo
import lotto.model.lotto.Bonus
import lotto.model.lotto.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputTest {
    private val validator = InputValidator()
    private val converter = InputConverter()

    @Nested
    inner class InputValidatorTest {

        @ParameterizedTest
        @EmptySource
        fun `입력값이 비어있으면 예외가 발생한다`(입력값: String) {
            Assertions.assertThatThrownBy { validator.checkInputDigit(입력값) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.EMPTY.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["1 ", "123a"])
        fun `입력값에 숫자가 아닌 문자가 있으면 예외가 발생한다`(입력값: String) {
            Assertions.assertThatThrownBy { validator.checkInputDigit(입력값) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.DIGIT.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["9876543210", "12345678900000"])
        fun `입력값이 Int의 MAX_VALUE보다 크면 예외가 발생한다`(입력값: String) {
            Assertions.assertThatThrownBy { validator.checkInputDigit(입력값) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INT_MAX.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["1", "45", "10"])
        fun `입력값이 조건을 만족하면 예외가 발생하지 않는다`(입력값: String) {
            Assertions.assertThatCode {
                validator.checkInputDigit(입력값)
            }
                .doesNotThrowAnyException()
        }

        @ParameterizedTest
        @ValueSource(strings = [",1,2,3,4,5,6", "1,2,3,4,5,6,", "1,,2,3,4,5,6"])
        fun `입력받은 당첨 번호의 쉼표가 잘못 입력되면 예외가 발생한다`(입력_당첨번호: String) {
            Assertions.assertThatThrownBy { validator.checkWinningLotto(입력_당첨번호) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.LOTTO_COMMA.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3,4,5 ,6", "1,2,3,4,5a,6"])
        fun `입력받은 당첨 번호에 숫자가 아닌 문자가 포함되면 예외가 발생한다`(입력_당첨번호: String) {
            Assertions.assertThatThrownBy { validator.checkWinningLotto(입력_당첨번호) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.DIGIT.toString())
        }

        @Test
        fun `당첨 번호가 조건을 만족하면 예외가 발생하지 않는다`() {
            Assertions.assertThatCode {
                validator.checkWinningLotto("1,2,3,4,5,6")
            }
                .doesNotThrowAnyException()
        }
    }

    @Nested
    inner class InputConverterTest {

        @Test
        fun `입력받은 구매 금액 문자열을 PurchaseInfo 객체로 변환한다`() {
            // given
            val 구매금액_문자열 = "5000"

            // when
            val 결과 = converter.convertPurchaseInfo(구매금액_문자열)

            // then
            Assertions.assertThat(결과)
                .isInstanceOf(PurchaseInfo::class.java)
        }

        @Test
        fun `입력받은 당첨 번호 문자열을 Lotto 객체로 변환한다`() {
            // given
            val 당첨번호_문자열 = "1,4,6,10,15,29"

            // when
            val 결과 = converter.convertLotto(당첨번호_문자열)

            // then
            Assertions.assertThat(결과)
                .isInstanceOf(Lotto::class.java)
            Assertions.assertThat(Lotto(listOf(1, 4, 6, 10, 15, 29)).countMatchingNumber(결과))
                .isEqualTo(6)
        }

        @Test
        fun `입력받은 보너스 번호 문자열을 Bonus 객체로 변환한다`() {
            // given
            val 보너스번호_문자열 = "43"

            // when
            val 결과 = converter.convertBonus(보너스번호_문자열)

            // then
            Assertions.assertThat(결과)
                .isInstanceOf(Bonus::class.java)
        }
    }

}