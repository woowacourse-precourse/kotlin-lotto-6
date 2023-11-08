package lotto.ui.view

import lotto.domain.model.Lotto
import lotto.domain.model.Money
import lotto.ui.presenter.LottoPresenter

interface LottoView {
    fun bindPresenter(presenter: LottoPresenter)
    fun onStart()
    fun displayEnterMoney()
    fun getMoney(): Money
    fun onGetMoneyDone()
    fun displayNumberOfBoughtLottoes(number: Int)
    fun displayLottoes(lottoes: List<Lotto>)
    fun displayErrorMessage(message: String?)
}