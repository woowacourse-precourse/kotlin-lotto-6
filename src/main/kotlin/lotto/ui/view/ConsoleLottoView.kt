package lotto.ui.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.model.BonusNumber
import lotto.domain.model.Money
import lotto.domain.model.Result
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

    override fun onGetBonusNumberDone() {
        presenter.getResults()
    }

    override fun displayResults(results: Map<Result, Int>) {
        val resultsToPrint = Result.values().dropLast(n = 1) // NOTHING은 출력하지 않는다

        resultsToPrint.forEach {
            val resultCount = results[it] ?: 0
            println("${it.convertToString()} - ${resultCount}개")
        }
    }

    private fun Result.convertToString(): String = buildString {
        append(matchingNumberCount)
        append(MATCHING_NUMBERS_SUFFIX_MESSAGE)
        if (this@convertToString == Result.SECOND_PLACE) append(BONUS_NUMBER_MATCH_MESSAGE)
        append(' ')
        append('(')
        append(PRIZE_FORMAT.format(prize))
        append(KRW)
        append(')')
    }

    override fun onGetResultsDone() {
        presenter.getProfit()
    }

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
        const val MATCHING_NUMBERS_SUFFIX_MESSAGE = "개 일치"
        const val BONUS_NUMBER_MATCH_MESSAGE = ", 보너스 볼 일치"
        const val PRIZE_FORMAT = "%,d"
        const val KRW = "원"
    }
}