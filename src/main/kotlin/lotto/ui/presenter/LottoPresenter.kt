package lotto.ui.presenter

import lotto.domain.model.Lotto
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

    private lateinit var lottoes: List<Lotto>

    fun getMoney() {
        view.displayMessage(ENTER_MONEY_MESSAGE)

        runCatching {
            view.getMoney()
        }.onSuccess {
            _money = it
        }.onFailure { error ->
            view.displayErrorMessage(message = error.message)
            getMoney()
        }
    }

    fun getLottoes() {
        val numberOfBoughtLottoes = money.amount / Money.DIVISION_AMOUNT
        view.displayMessage("\n$numberOfBoughtLottoes$NUMBER_OF_BOUGHT_LOTTOES_MESSAGE")

        lottoes = repository.getLottoes(amount = money.amount / Money.DIVISION_AMOUNT)
        lottoes.forEach { view.displayMessage(it.toString()) }
    }

    companion object {
        const val ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        const val NUMBER_OF_BOUGHT_LOTTOES_MESSAGE = "개를 구매했습니다."
    }
}