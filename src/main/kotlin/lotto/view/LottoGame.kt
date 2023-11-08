package lotto.view

import lotto.viewmodel.LottoViewModel
import lotto.viewmodel.InputMoneyViewModel
import lotto.viewmodel.InputNumberViewModel
import lotto.viewmodel.ResultViewModel

class LottoGame {
    private val lottoViewModel = LottoViewModel()
    private val lottoView = LottoView(lottoViewModel)

    private val inputMoneyViewModel = InputMoneyViewModel()
    private val inputMoneyView = InputMoneyView(inputMoneyViewModel)

    private val inputNumberViewModel = InputNumberViewModel()
    private val inputNumberView = InputNumberView(inputNumberViewModel)

    private val resultViewModel = ResultViewModel()
    private val resultView = ResultView(resultViewModel)

    private fun inputMoney() = inputMoneyView.inputMoney()
    private fun displayLotto() = lottoView.displayLotto()
    private fun inputLottoNumber() = inputNumberView.inputLottoNumber()
    private fun inputBonusNumber() = inputNumberView.inputBonusNumber()
    private fun displayResult() = resultView.displayResultReport()

    private fun initErrorListener() {
        inputMoneyViewModel.inputMoneyErrorListener = inputMoneyView
        inputNumberViewModel.inputNumberErrorListener = inputNumberView
    }

    private fun initInputListener() {
        inputMoneyViewModel.inputMoneyListener = lottoViewModel
        inputNumberViewModel.inputNumberListener = resultViewModel
        lottoViewModel.generateLottoListener = resultViewModel
    }

    fun runGame() {
        initInputListener()
        initErrorListener()
        inputMoney()
        displayLotto()
        inputLottoNumber()
        inputBonusNumber()
        displayResult()
    }
}