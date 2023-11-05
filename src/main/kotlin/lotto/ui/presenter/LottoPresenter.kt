package lotto.ui.presenter

import lotto.domain.model.Money
import lotto.ui.view.LottoView

class LottoPresenter(
    private val view: LottoView
) {
    // inline class는 lateinit var 불가
    private var _money: Money? = null
    private val money get() = requireNotNull(_money)

    fun getMoney() {
        view.displayEnterMoney()

        runCatching {
            view.getMoney()
        }.onSuccess {
            _money = it
        }.onFailure { error ->
            view.displayErrorMessage(message = error.message)
            view.displayEnterMoney()
            view.getMoney()
        }
    }
}