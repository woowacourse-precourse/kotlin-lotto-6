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
    fun `유효한 로또 구입 금액 입력`() {
        var lottoPurchaseAmount = 54000
        inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
    }

    @Test
    fun `1000원 단위로 나누어 떨어지지 않는 로또 구입 금액 입력 시 예외 처리`() {
        var lottoPurchaseAmount = 4300
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.DIVISION_BY_THOUSAND_ERROR, exception.message)

    }

    @Test
    fun `로또 구입 금액으로 0 입력 시 예외 처리`() {
        var lottoPurchaseAmount = 0
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.INPUT_ZERO_AMOUNT_ERROR, exception.message)

    }

    @Test
    fun `로또 구입 금액으로 음수 입력 시 예외 처리`() {
        var lottoPurchaseAmount = -5000
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.INPUT_NEGATIVE_AMOUNT_ERROR, exception.message)
    }

    @Test
    fun `유효한 로또 당첨 번호 입력`() {
        var inputLottoNum = "1,2 ,4,6,7,8"
        inputValidation.validateInputLottoNum(inputLottoNum)
    }

    @Test
    fun `로또 당첨 번호 중 맨 앞에 쉼표 입력 시 예외 처리`() {
        var inputLottoNum = ",1,2,4,6,7, 8"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateInputLottoNum(inputLottoNum)
        }
        assertEquals(InputValidation.SEPARATE_BY_COMMA_ERROR, exception.message)
    }

    @Test
    fun `로또 당첨 번호 중 맨 뒤에 쉼표 입력 시 예외 처리`() {
        var inputLottoNum = "1,2,4,6,7,8,"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateInputLottoNum(inputLottoNum)
        }
        assertEquals(InputValidation.SEPARATE_BY_COMMA_ERROR, exception.message)
    }
}