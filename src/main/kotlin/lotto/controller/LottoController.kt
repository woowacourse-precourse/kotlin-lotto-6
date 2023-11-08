package lotto.controller

import lotto.model.Lotto
import lotto.model.Winning
import lotto.util.NumberPicker
import lotto.util.RateOfReturnCalculator
import lotto.util.lottoPrice
import lotto.util.validations.LottoBonusNumbersValidator
import lotto.util.validations.LottoNumbersValidator
import lotto.util.validations.PriceValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private var numberOfLottoTickets = 0
    private val lottos = mutableListOf<Lotto>()
    private lateinit var userLottos: Lotto
    private var userLottoBonusNumber = 0
    private val winnings = Winning.values()

    fun showLottoWinningNumbers() {
        lottos.forEach {
            it.printWinningNumbers()
        }
    }

    fun getLottoPurchaseAmount(): String {
        OutputView.printPriceMessage()
        return InputView.inputPrice()
    }

    fun getNumberOfLottoTickets(lottoPurchaseAmount: String) {
        val lottoTickets = lottoPurchaseAmount.toIntOrNull()
        if (PriceValidator.inputPrice(lottoPurchaseAmount)) {
            OutputView.printLottoCountMessage(lottoTickets!! / lottoPrice)
            numberOfLottoTickets = lottoTickets / lottoPrice
        }
    }

    fun getLottoWinningNumbers() {
        repeat(numberOfLottoTickets) {
            val numbers = NumberPicker.pickNumbers()
            Lotto(numbers).apply {
                lottos.add(this)
            }
        }
    }

    fun getUserLottoNumbers(): String {
        return InputView.inputNumbers()
    }

    fun validateUserLottoNumbers(userInputNumbers: String) {
        val parsedUserInputNumbers = userInputNumbers.split(",").filter {
            it.isNotEmpty()
        }.map {
            it.toIntOrNull()
        }
        if (LottoNumbersValidator.inputNumbers(parsedUserInputNumbers)) {
            parsedUserInputNumbers.map { it!! }.apply {
                Lotto(this).apply {
                    userLottos = this
                }
            }
        }
    }

    fun getUserBonusLottoNumber(): String {
        return InputView.inputBonusNumber()
    }

    fun validateUserBonusLottoNumber(userInputBonusNumber: String) {
        if (LottoBonusNumbersValidator.inputNumber(userLottos, userInputBonusNumber)) {
            userInputBonusNumber.toInt().apply {
                userLottoBonusNumber = this
            }
        }
    }

    fun checkWinning() {
        lottos.forEach {
            val winningResult = it.checkWinning(userLottos, userLottoBonusNumber)
            winnings.toList().indexOf(winningResult).apply {
                if (this >= 0) winnings[this].winningCnt++
            }
        }
    }

    fun showWinningResult() {
        OutputView.printWinningStatisticsMessage()
        winnings.forEach {
            OutputView.printWinningResult(it.msg, it.winningPrice, it.winningCnt)
        }
    }

    fun calculateRateOfReturn(): String {
        val totalWinningPrice = winnings.fold(0) { acc, winning ->
            acc + winning.winningPrice * winning.winningCnt
        }
        return RateOfReturnCalculator.calculateRateOfReturn(totalWinningPrice, numberOfLottoTickets)
    }

    fun showRateOfReturn(totalRateOfReturn: String) {
        OutputView.printTotalRateOfReturnMessage(totalRateOfReturn)
    }

}