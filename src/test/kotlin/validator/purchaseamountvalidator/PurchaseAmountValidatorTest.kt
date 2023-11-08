package validator.purchaseamountvalidator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import validator.purchaseamountvalidator.PurchaseAmountValidator

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "30000", "100000"])
    fun `적절한 로또 구입 금액일 때 성공하는지 확인`(input: String) {
        val result = PurchaseAmountValidator.isAppropriatePurchaseAmount(input)

        assertThat(result).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1001", "1222", "12100", "1300100", "0", "-1000"])
    fun `잘못된 로또 구입 금액일 때 예외를 던지는지 확인`(input: String) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.isAppropriatePurchaseAmount(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1a12", "오류입니다", "로또10000", "10000원"])
    fun `잘못된 로또 형식일 때 예외를 던지는지 확인`(input: String) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.isAppropriatePurchaseAmount(input)
        }
    }
}
