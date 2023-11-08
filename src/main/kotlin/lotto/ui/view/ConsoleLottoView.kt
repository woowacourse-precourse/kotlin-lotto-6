package lotto.ui.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.model.BonusNumber
import lotto.domain.model.Money
import lotto.domain.model.WinningNumbers
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

    override fun getMoney(): Money = Money(amount = readInt())

    override fun onGetMoneyDone() {
        presenter.getLottoes()
    }

    override fun onGetLottoesDone() {
        presenter.getWinningNumbers()
    }

    override fun getWinningNumbers(): WinningNumbers {
        val numbers = runCatching {
            Console.readLine().split(NUMBER_DELIMITER).map(String::toInt)
        }.onFailure {
            throw NumberFormatException(INPUT_NOT_NUMBER)
        }.getOrThrow()

        return WinningNumbers(numbers = numbers)
    }

    override fun onGetWinningNumbersDone() {
        presenter.getBonusNumber()
    }

    override fun getBonusNumber(): BonusNumber = BonusNumber(number = readInt())

    private fun readInt(): Int = runCatching {
        Console.readLine().toInt()
    }.onFailure {
        throw NumberFormatException(INPUT_NOT_NUMBER)
    }.getOrThrow()

    companion object {
        const val ERROR_MESSAGE_PREFIX = "[ERROR]"
        const val DEFAULT_ERROR_MESSAGE = "에러가 발생했습니다. 다시 시도해주세요."
        const val NUMBER_DELIMITER = ','
        const val INPUT_NOT_NUMBER = "숫자를 입력해 주세요."
    }
}