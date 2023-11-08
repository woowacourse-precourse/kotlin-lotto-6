package lotto.ui.presenter

import lotto.domain.model.Money
import lotto.domain.repository.LottoRepository
import lotto.ui.view.LottoView

class LottoPresenter(
    private val view: LottoView,
    private val repository: LottoRepository
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
            onSuccessGetMoney()
        }.onFailure { error ->
            view.displayErrorMessage(message = error.message)
            onFailureGetMoney()
        }
    }

    private fun onSuccessGetMoney() {
        view.displayNumberOfBoughtLottoes(number = money.amount / Money.DIVISION_AMOUNT)
    }

    private fun onFailureGetMoney() {
        view.displayEnterMoney()
        view.getMoney()
    }

    fun getLottoes() {
        view.displayNumberOfBoughtLottoes(number = money.amount / Money.DIVISION_AMOUNT)

        val lottoes = repository.getLottoes(amount = money.amount / Money.DIVISION_AMOUNT)
        view.displayLottoes(lottoes = lottoes)
    }
}