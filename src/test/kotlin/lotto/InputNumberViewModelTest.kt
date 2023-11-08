package lotto

import lotto.model.ERROR
import lotto.observer.InputNumberErrorListener
import lotto.observer.InputNumberListener
import lotto.viewmodel.InputNumberViewModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class InputNumberViewModelTest {
    private lateinit var viewModel: InputNumberViewModel
    private lateinit var inputNumberErrorListener: InputNumberErrorListener
    private lateinit var inputNumberListener: InputNumberListener

    @BeforeEach
    fun `테스트를 위한 설정`() {
        inputNumberErrorListener = mock(InputNumberErrorListener::class.java)
        inputNumberListener = mock(InputNumberListener::class.java)

        viewModel = InputNumberViewModel().apply {
            this.inputNumberErrorListener = this@InputNumberViewModelTest.inputNumberErrorListener
            this.inputNumberListener = this@InputNumberViewModelTest.inputNumberListener
        }
    }

    @Test
    fun `유효한 로또 번호를 입력했을 때 리스너가 호출되어야 함`() {
        val validLottoNumber = "1, 2, 3, 4, 5, 6"
        viewModel.updateLottoNumber(validLottoNumber)
        val validLottoNumberList = listOf(1, 2, 3, 4, 5, 6)
        verify(inputNumberListener).inputNumberListener(validLottoNumberList)
    }

    @Test
    fun `유효하지 않은 로또 번호를 입력했을 때 에러 리스너가 호출되어야 함`() {
        val invalidLottoNumber = "1, 2, 3, 4, 5"
        viewModel.updateLottoNumber(invalidLottoNumber)

        verify(inputNumberErrorListener).onLottoNumberError(ERROR.INVALID_SIZE.message)
    }

    @Test
    fun `유효한 보너스 번호를 입력했을 때 리스너가 호출되어야 함`() {
        viewModel.updateLottoNumber("1, 2, 3, 4, 5, 6")
        val validBonusNumber = "7"
        viewModel.updateBonusNumber(validBonusNumber)

        verify(inputNumberListener).inputBonusNumberListener(eq(7))
    }

    @Test
    fun `로또 번호와 중복된 보너스 번호를 입력했을 때 에러 리스너가 호출되어야 함`() {
        viewModel.updateLottoNumber("1, 2, 3, 4, 5, 6")
        val validBonusNumber = "6"
        viewModel.updateBonusNumber(validBonusNumber)

        verify(inputNumberErrorListener).onBonusNumberError(ERROR.DUPLICATED_NUMBER.message)
    }

    @Test
    fun `범위 밖의 보너스 번호를 입력했을 때 에러 리스너가 호출되어야 함`() {
        viewModel.updateLottoNumber("1, 2, 3, 4, 5, 6")
        val validBonusNumber = "49"
        viewModel.updateBonusNumber(validBonusNumber)

        verify(inputNumberErrorListener).onBonusNumberError(ERROR.OUT_OF_RANGE.message)
    }
}