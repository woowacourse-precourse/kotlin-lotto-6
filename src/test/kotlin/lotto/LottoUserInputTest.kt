package lotto

import lotto.enums.PriceInputType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoUserInputTest {

    @Test
    fun `숫자가 아닌 문자열을 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkPriceInput("input")).isEqualTo(PriceInputType.NOT_INTEGER)
    }

    @Test
    fun `양수가 아닌 수를 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkPriceInput("0")).isEqualTo(PriceInputType.NOT_POSITIVE)
        assertThat(LottoUserInput.checkPriceInput("-100")).isEqualTo(PriceInputType.NOT_POSITIVE)
    }
    @Test
    fun `1000의 배수가 아닌 수를 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkPriceInput("190")).isEqualTo(PriceInputType.NOT_MULTIPLE_OF_1000)
        assertThat(LottoUserInput.checkPriceInput("2137")).isEqualTo(PriceInputType.NOT_MULTIPLE_OF_1000)
    }

    @Test
    fun `모든 조건을 만족하는 수를 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkPriceInput("5000")).isEqualTo(PriceInputType.VALID)
        assertThat(LottoUserInput.checkPriceInput("13000")).isEqualTo(PriceInputType.VALID)
        assertThat(LottoUserInput.checkPriceInput("770000")).isEqualTo(PriceInputType.VALID)

    }

}