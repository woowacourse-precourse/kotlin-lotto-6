package lotto.ui.view

import lotto.domain.model.Money
import lotto.domain.model.WinningNumbers
import lotto.ui.presenter.LottoPresenter

interface LottoView {
    fun bindPresenter(presenter: LottoPresenter)
    fun displayMessage(message: String)
    fun displayErrorMessage(message: String?)
    fun onStart()
    fun getMoney(): Money
    fun onGetMoneyDone()
    fun onGetLottoesDone()
    fun getWinningNumbers(): WinningNumbers
}