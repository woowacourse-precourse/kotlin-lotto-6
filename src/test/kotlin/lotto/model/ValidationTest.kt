package lotto.model

import lotto.model.validation.LottoNumValidation
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
        var lottoPurchaseAmount = "54000"
        inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
    }

    @Test
    fun `1000원 단위로 나누어 떨어지지 않는 로또 구입 금액 입력 시 예외 처리`() {
        var lottoPurchaseAmount = "4300"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.DIVISION_BY_THOUSAND_ERROR, exception.message)

    }

    @Test
    fun `로또 구입 금액으로 0 입력 시 예외 처리`() {
        var lottoPurchaseAmount = "0"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.INPUT_ZERO_VALUE_ERROR, exception.message)
    }

    @Test
    fun `로또 구입 금액으로 음수 입력 시 예외 처리`() {
        var lottoPurchaseAmount = "-5000"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateLottoPurchaseAmount(lottoPurchaseAmount)
        }
        assertEquals(InputValidation.INPUT_NEGATIVE_VALUE_ERROR, exception.message)
    }

    @Test
    fun `유효한 로또 당첨 번호 입력`() {
        var inputLottoNum = "1,2,4,6,7,8"
        inputValidation.validateInputWinningLottoNum(inputLottoNum)
    }

    @Test
    fun `로또 당첨 번호 중 공백 입력`() {
        var inputLottoNum = "1,2,4,  6,7,8"
        inputValidation.validateInputWinningLottoNum(inputLottoNum)
    }


    @Test
    fun `로또 당첨 번호 중 맨 앞에 쉼표 입력 시 예외 처리`() {
        var inputLottoNum = ",1,2,4,6,7, 8"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateInputWinningLottoNum(inputLottoNum)
        }
        assertEquals(InputValidation.SEPARATE_BY_COMMA_ERROR, exception.message)
    }

    @Test
    fun `로또 당첨 번호 중 맨 뒤에 쉼표 입력 시 예외 처리`() {
        var inputLottoNum = "1,2,4,6,7,8,"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateInputWinningLottoNum(inputLottoNum)
        }
        assertEquals(InputValidation.SEPARATE_BY_COMMA_ERROR, exception.message)
    }

    @Test
    fun `보너스 번호 0 입력 시 예외 처리`() {
        var lottoBonusNum = "0"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateInputBonusNum(lottoBonusNum)
        }
        assertEquals(InputValidation.INPUT_ZERO_VALUE_ERROR, exception.message)
    }

    @Test
    fun `보너스 번호 음수 입력 시 예외 처리`() {
        var lottoBonusNum = "-20"
        val exception: Exception = assertThrows<IllegalArgumentException> {
            inputValidation.validateInputBonusNum(lottoBonusNum)
        }
        assertEquals(InputValidation.INPUT_NEGATIVE_VALUE_ERROR, exception.message)
    }

    @Test
    fun `유효한 로또 당첨 숫자 리스트 입력`() {
        var inputLottoNum: List<Int> = mutableListOf(1, 2, 4, 5, 6, 7)
        lottoNumValidation.validateLottoNum(inputLottoNum)
    }

    @Test
    fun `7개의 로또 번호 입력 시 예외 처리`() {
        var inputLottoNum: List<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7)
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateLottoNum(inputLottoNum)
        }
        assertEquals(LottoNumValidation.LOTTO_NUM_SIZE_ERROR, exception.message)
    }

    @Test
    fun `5개의 로또 번호 입력 시 예외 처리`() {
        var inputLottoNum: List<Int> = mutableListOf(1, 2, 3, 4, 5)
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateLottoNum(inputLottoNum)
        }
        assertEquals(LottoNumValidation.LOTTO_NUM_SIZE_ERROR, exception.message)
    }

    @Test
    fun `중복된 로또 번호 입력 시 예외 처리`() {
        var inputLottoNum: List<Int> = mutableListOf(1, 2, 3, 4, 5, 5)
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateLottoNum(inputLottoNum)
        }
        assertEquals(LottoNumValidation.DUPLICATE_LOTTO_NUM_ERROR, exception.message)
    }

    @Test
    fun `45보다 큰 범위 외의 숫자 입력 시 예외 처리`() {
        var inputLottoNum: List<Int> = mutableListOf(1, 2, 46, 5, 6, 7)
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateLottoNum(inputLottoNum)
        }
        assertEquals(LottoNumValidation.LOTTO_NUM_RANGE_ERROR, exception.message)
    }

    @Test
    fun `1보다 작은 범위 외의 숫자 입력 시 예외 처리`() {
        var inputLottoNum: List<Int> = mutableListOf(1, 2, 0, 5, 6, 7)
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateLottoNum(inputLottoNum)
        }
        assertEquals(LottoNumValidation.LOTTO_NUM_RANGE_ERROR, exception.message)
    }
    @Test
    fun `45보다 큰 보너스 번호 입력 시 예외 처리`() {
        var inputLottoNum: Lotto = Lotto(mutableListOf(1, 2, 3, 5, 6, 7))
        var inputBonusNum = 58
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateBonusLottoNum(inputLottoNum, inputBonusNum)
        }
        assertEquals(LottoNumValidation.LOTTO_NUM_RANGE_ERROR, exception.message)
    }
    @Test
    fun `1보다 작은 보너스 번호 입력 시 예외 처리`() {
        var inputLottoNum: Lotto = Lotto(mutableListOf(1, 2, 3, 5, 6, 7))
        var inputBonusNum = -1
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateBonusLottoNum(inputLottoNum, inputBonusNum)
        }
        assertEquals(LottoNumValidation.LOTTO_NUM_RANGE_ERROR, exception.message)
    }
    @Test
    fun `로또 당첨 번호와 중복되는 보너스 번호 입력 시 예외 처리`() {
        var inputLottoNum: Lotto = Lotto(mutableListOf(1, 2, 3, 5, 6, 7))
        var inputBonusNum = 2
        val exception: Exception = assertThrows<IllegalArgumentException> {
            lottoNumValidation.validateBonusLottoNum(inputLottoNum, inputBonusNum)
        }
        assertEquals(LottoNumValidation.DUPLICATE_BONUS_NUM_ERROR, exception.message)
    }
}