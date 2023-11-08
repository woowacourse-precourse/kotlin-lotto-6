package lotto

import lotto.model.ERROR
import lotto.observer.InputMoneyErrorListener
import lotto.observer.InputMoneyListener
import lotto.viewmodel.InputMoneyViewModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class InputMoneyViewModelTest {
    private lateinit var viewModel: InputMoneyViewModel
    private lateinit var inputMoneyListener: InputMoneyListener
    private lateinit var inputMoneyErrorListener: InputMoneyErrorListener

    @BeforeEach
    fun setUp() {
        inputMoneyListener = mock(InputMoneyListener::class.java)
        inputMoneyErrorListener = mock(InputMoneyErrorListener::class.java)

        viewModel = InputMoneyViewModel().apply {
            this.inputMoneyListener = this@InputMoneyViewModelTest.inputMoneyListener
            this.inputMoneyErrorListener = this@InputMoneyViewModelTest.inputMoneyErrorListener
        }
    }

    @Test
    fun `정상적인 금액 입력시 리스너 호출 확인`() {
        val validMoney = "5000"
        viewModel.updateMoney(validMoney)
        verify(inputMoneyListener).inputMoneyListener(5000)
    }

    @Test
    fun `비정상적인 금액 입력시 에러 리스너 호출 확인`() {
        val invalidMoney = "550"
        viewModel.updateMoney(invalidMoney)
        verify(inputMoneyErrorListener).onMoneyError(ERROR.INVALID_PURCHASE_AMOUNT.message)
    }
}
