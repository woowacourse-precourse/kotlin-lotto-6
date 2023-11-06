package lotto.ModuleTest

import lotto.model.LottoNumValidation
import lotto.model.validation.InputValidation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationTest {
    private lateinit var lottoNumValidation: LottoNumValidation
    private lateinit var inputValidation: InputValidation

    @BeforeEach
    fun `Initialize Validation Class`() {
        lottoNumValidation = LottoNumValidation()
        inputValidation = InputValidation()
    }

    @Test
    fun `조건에 맞는 로또 구입 금액 입력`() {
        var lottoPurchaseAmount = 54000
        inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
    }

    @Test
    fun `1000원 단위로 나누어 떨어지지 않는 로또 구입 금액 입력`() {
        var lottoPurchaseAmount = 4300
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.DIVISION_BY_THOUSAND_ERROR, exception.message)

    }

    @Test
    fun `로또 구입 금액으로 0 입력`() {
        var lottoPurchaseAmount = 0
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.INPUT_ZERO_AMOUNT_ERROR, exception.message)

    }

    @Test
    fun `로또 구입 금액으로 음수 입력`() {
        var lottoPurchaseAmount = -5000
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.INPUT_NEGATIVE_AMOUNT_ERROR, exception.message)
    }
}