package lotto.presentation.view

import lotto.presentation.viewmodel.LottoViewModel

class LottoView {
    val lottoInputView = LottoInputView()
    val lottoOutputView = LottoOutputView()
    val lottoViewModel = LottoViewModel()
    fun purchaseLottos(){
        lottoOutputView.printInputPurchasePrice()
        lottoViewModel.initialCustomer(lottoInputView.getPrice())
        lottoOutputView.printPurchaseCount(lottoViewModel.customer.lotteries.size)
        lottoOutputView.printPurchaseLottosNumbers(lottoViewModel.customer)
    }
}