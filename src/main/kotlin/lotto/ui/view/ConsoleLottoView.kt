package lotto.ui.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.model.Money
import lotto.ui.presenter.LottoPresenter

class ConsoleLottoView : LottoView {
    private lateinit var presenter: LottoPresenter

    override fun bindPresenter(presenter: LottoPresenter) {
        this.presenter = presenter
    }

    override fun displayMessage(message: String) {
        println(message)
    }

    override fun displayErrorMessage(message: String?) {
        println("$ERROR_MESSAGE_PREFIX ${message ?: DEFAULT_ERROR_MESSAGE}")
    }

    override fun onStart() {
        presenter.getMoney()
    }

    override fun getMoney(): Money = Money(amount = Console.readLine().toInt())

    override fun onGetMoneyDone() {
        presenter.getLottoes()
    }

    companion object {
        const val ERROR_MESSAGE_PREFIX = "[ERROR]"
        const val DEFAULT_ERROR_MESSAGE = "에러가 발생했습니다. 다시 시도해주세요."
    }
}