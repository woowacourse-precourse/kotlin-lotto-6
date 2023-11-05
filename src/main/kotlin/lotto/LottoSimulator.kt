package lotto

import lotto.ui.presenter.LottoPresenter
import lotto.ui.view.LottoView

class LottoSimulator(
    private val view: LottoView,
    private val presenter: LottoPresenter
) {
    fun start() {
        view.bindPresenter(presenter = presenter)

        view.onStart()
        view.onGetMoneyDone()
        view.onGetLottoesDone()
    }
}