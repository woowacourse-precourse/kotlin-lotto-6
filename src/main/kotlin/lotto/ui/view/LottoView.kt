package lotto.ui.view

import lotto.domain.model.Money
import lotto.ui.presenter.LottoPresenter

interface LottoView {
    fun bindPresenter(presenter: LottoPresenter)
    fun onStart()
    fun displayEnterMoney()
    fun getMoney(): Money
    fun displayErrorMessage(message: String?)
}