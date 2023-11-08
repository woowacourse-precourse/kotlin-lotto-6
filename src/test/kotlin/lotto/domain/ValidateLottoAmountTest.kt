package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import org.junit.jupiter.api.assertThrows
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.ApplicationTest

class ValidateLottoAmountTest{
    val validateLottoAmount = ValidateLottoAmount()

    @Test
    @DisplayName("입력한 구매 금액이 빈칸인 경우")
    fun validateBuyAmountEmpty() {
        assertThrows<IllegalArgumentException>{
            validateLottoAmount.validateBuyAmountEmpty("\n")
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력한 구매 금액에 문자가 포함된 경우")
    fun validateBuyAmountString() {
        assertThrows<IllegalArgumentException>{
            validateLottoAmount.validateBuyAmountString("800j")
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력한 구매 금액이 1000원 미만인 경우")
    fun validateBuyAmountUnderLottoPrice() {
        assertThrows<IllegalArgumentException>{
            validateLottoAmount.validateBuyAmountUnderLottoPrice(999)
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력한 구매 금액이 1000원으로 나누어 떨어지지 않는 경우")
    fun validateBuyAmountNotDivideByLottoPrice() {
        assertThrows<IllegalArgumentException>{
            validateLottoAmount.validateBuyAmountDivideByLottoPrice(8800)
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력한 구매 금액이 정상 입력된 경우")
    fun validateBuyAmountDivideByLottoPrice() {
        assertThat(validateLottoAmount.buyAmount("8000")).isEqualTo(8)
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}