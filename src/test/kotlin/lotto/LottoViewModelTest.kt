package lotto

import lotto.observer.GenerateLottoListener
import lotto.viewmodel.LottoViewModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.*

class LottoViewModelTest {
    private lateinit var viewModel: LottoViewModel
    private lateinit var generateLottoListener: GenerateLottoListener

    @BeforeEach
    fun setUp() {
        generateLottoListener = mock(GenerateLottoListener::class.java)
        viewModel = LottoViewModel().apply {
            this.generateLottoListener = this@LottoViewModelTest.generateLottoListener
        }
    }

    @Test
    fun `입력된 금액에 따른 로또 횟수 계산`() {
        val money = 5000
        viewModel.inputMoneyListener(money)
        assertEquals(5, viewModel.numberOfLotto)
    }

    @Test
    fun `생성된 로또 번호가 중복되지 않는지 확인`() {
        viewModel.inputMoneyListener(5000)
        viewModel.lotto.forEach { lotto ->
            assertEquals(6, lotto.toSet().distinct().size)
        }
    }

    @Test
    fun `로또 생성 후 리스너 호출 확인`() {
        viewModel.inputMoneyListener(5000)
        verify(generateLottoListener).generateLotto(viewModel.lotto)
    }
}
