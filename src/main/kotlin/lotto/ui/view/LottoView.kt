package lotto.ui.view

import lotto.domain.model.BonusNumber
import lotto.domain.model.Money
import lotto.domain.model.Result
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
    fun onGetWinningNumbersDone()
    fun getBonusNumber(): BonusNumber
    fun getBonusNumberDone()
    fun displayResults(results: Map<Result, Int>)
    fun onGetResultsDone()
}