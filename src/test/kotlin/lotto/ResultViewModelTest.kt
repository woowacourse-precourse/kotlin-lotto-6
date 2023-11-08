package lotto

import lotto.model.Lotto
import lotto.viewmodel.ResultViewModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ResultViewModelTest {
    private lateinit var viewModel: ResultViewModel

    @BeforeEach
    fun setUp() {
        viewModel = ResultViewModel()
    }

    @Test
    fun `로또 번호 입력시 내부 상태 업데이트`() {
        val inputNumbers = listOf(1, 2, 3, 4, 5, 6)
        viewModel.inputNumberListener(inputNumbers)
        assertEquals(inputNumbers, viewModel.inputLottoNumber)
    }

    @Test
    fun `보너스 번호 입력과 결과 초기화`() {
        val inputNumbers = listOf(1, 2, 3, 4, 5, 6)
        viewModel.inputNumberListener(inputNumbers)

        val mockLottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )

        viewModel.generateLotto(mockLottoList)

        val bonusNumber = 7
        viewModel.inputBonusNumberListener(bonusNumber)

        assertEquals(bonusNumber, viewModel.bonusNumber)
    }

    @Test
    fun `로또 리스트 입력시 내부 상태 업데이트`() {
        val mockLottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )

        viewModel.generateLotto(mockLottoList)
        assertEquals(mockLottoList, viewModel.lotto)
    }

    @Test
    fun `결과 업데이트시 올바른 문자열 반환`() {
        val resultString = viewModel.updateResult()
        assertNotNull(resultString)
    }

    @Test
    fun `수익률 계산시 올바른 문자열 반환`() {
        val mockLottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )

        viewModel.generateLotto(mockLottoList)
        assertEquals(mockLottoList, viewModel.lotto)

        val rateOfReturnString = viewModel.initRateOfReturn()
        assertNotNull(rateOfReturnString)
    }
}