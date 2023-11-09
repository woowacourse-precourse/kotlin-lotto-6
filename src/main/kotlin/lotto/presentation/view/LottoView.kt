package lotto.presentation.view

import lotto.presentation.viewmodel.LottoViewModel

class LottoView {
    private val lottoInputView = LottoInputView()
    private val lottoOutputView = LottoOutputView()
    private val lottoViewModel = LottoViewModel()

    fun play(){
        purchaseLottos()
        decideWinningNumbers()
        generateStatistics()
    }
    private fun purchaseLottos() {
        lottoOutputView.printInputPurchasePrice()
        lottoViewModel.initialCustomer(lottoInputView.getPrice())
        lottoOutputView.printPurchaseCount(lottoViewModel.customer.lotteries.size)
        lottoOutputView.printPurchaseLottosNumbers(lottoViewModel.customer)
    }

    private fun decideWinningNumbers(){
        lottoOutputView.printInputWinningNumbers()
        val winningNumbers = lottoInputView.getWinningNumbers()
        lottoOutputView.printInputBonusNumber()
        val bonusNumber = lottoInputView.getBonusNumber()
        lottoViewModel.initialWinning(winningNumbers,bonusNumber)
    }

    private fun generateStatistics(){
        lottoOutputView.printWinningStatistics(lottoViewModel.formatWinningResult())
        lottoOutputView.printTotalReturnPercent(lottoViewModel.formatTotalReturnPercent())
    }

}