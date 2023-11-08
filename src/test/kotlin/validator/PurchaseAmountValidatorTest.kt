package validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import validator.purchaseamountvalidator.PurchaseAmountValidator

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 30_000, 100_000])
    fun `적절한 로또 구입 금액일 때 성공하는지 확인`(input: Int) {
        val result = PurchaseAmountValidator.isAppropriatePurchaseAmount(input)

        assertThat(result).isEqualTo(true)
    }
}
