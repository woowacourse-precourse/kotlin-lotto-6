package lotto.ui.presenter

import lotto.domain.model.*
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

    private var _winningNumbers: WinningNumbers? = null
    private val winningNumbers get() = requireNotNull(_winningNumbers)

    private var _bonusNumber: BonusNumber? = null
    private val bonusNumber get() = requireNotNull(_bonusNumber)

    private lateinit var results: Map<Result, Int>

    fun getMoney() {
        view.displayMessage(ENTER_MONEY_MESSAGE)

        runCatching {
            view.getMoney()
        }.onSuccess {
            _money = it
        }.onFailureOtherThanNoSuchElementException { error ->
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

    fun getWinningNumbers() {
        view.displayMessage("\n$ENTER_WINNING_NUMBERS_MESSAGE")

        runCatching {
            view.getWinningNumbers()
        }.onSuccess {
            _winningNumbers = it
        }.onFailureOtherThanNoSuchElementException { error ->
            view.displayErrorMessage(message = error.message)
            getWinningNumbers()
        }
    }

    fun getBonusNumber() {
        view.displayMessage("\n$ENTER_BONUS_NUMBER_MESSAGE")

        runCatching {
            view.getBonusNumber().also {
                require(it.number !in winningNumbers) { BonusNumber.NUMBER_EXISTS_IN_WINNING_NUMBERS }
            }
        }.onSuccess {
            _bonusNumber = it
        }.onFailureOtherThanNoSuchElementException { error ->
            view.displayErrorMessage(message = error.message)
            getBonusNumber()
        }
    }

    fun getResults() {
        results = lottoes.map {
            it.calculateResult(winningNumbers = winningNumbers, bonusNumber = bonusNumber)
        }.groupingBy { result ->
            result
        }.eachCount()

        view.displayResults(results = results)
    }

    fun getProfit() {
        var totalPrize = 0.0f

        results.forEach { (result, count) ->
            totalPrize += result.prize * count
        }

        val profit = (totalPrize / money.amount) * PERCENT

        view.displayMessage(PROFIT_FORMAT.format(profit))
    }

    // NoSuchElementException은 테스트에 사용되므로 처리하지 않는다.
    private fun <T> kotlin.Result<T>.onFailureOtherThanNoSuchElementException(action: (Throwable) -> Unit) =
        onFailure { error ->
            if (error is NoSuchElementException) throw error
            action(error)
        }

    companion object {
        const val ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        const val NUMBER_OF_BOUGHT_LOTTOES_MESSAGE = "개를 구매했습니다."
        const val ENTER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        const val ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
        const val PERCENT = 100
        const val PROFIT_FORMAT = "총 수익률은 %.1f%%입니다."
    }
}