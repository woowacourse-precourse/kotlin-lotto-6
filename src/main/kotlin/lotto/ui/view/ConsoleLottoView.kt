package lotto.ui.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.model.Money
import lotto.ui.presenter.LottoPresenter
import lotto.domain.model.Lotto

class ConsoleLottoView : LottoView {
    private lateinit var presenter: LottoPresenter

    override fun bindPresenter(presenter: LottoPresenter) {
        this.presenter = presenter
    }

    override fun onStart() {
        presenter.getMoney()
    }

    override fun displayEnterMoney() {
        println(ENTER_MONEY_MESSAGE)
    }

    override fun getMoney(): Money = Money(amount = Console.readLine().toInt())

    override fun onGetMoneyDone() {
        presenter.getLottoes()
    }

    override fun displayNumberOfBoughtLottoes(number: Int) {
        println("${number}$NUMBER_OF_BOUGHT_LOTTOES_MESSAGE")
    }

    override fun displayLottoes(lottoes: List<Lotto>) {
        lottoes.forEach(::println)
    }

    override fun displayErrorMessage(message: String?) {
        println("$ERROR_MESSAGE_PREFIX ${message ?: DEFAULT_ERROR_MESSAGE}")
    }

    companion object {
        const val ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        const val ERROR_MESSAGE_PREFIX = "[ERROR]"
        const val DEFAULT_ERROR_MESSAGE = "에러가 발생했습니다. 다시 시도해주세요."
        const val NUMBER_OF_BOUGHT_LOTTOES_MESSAGE = "개를 구매했습니다."
    }
}