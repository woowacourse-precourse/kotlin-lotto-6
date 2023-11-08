package lotto.domain.controller

import lotto.data.model.Lotto
import lotto.data.model.Winning
import lotto.domain.util.NumberPicker
import lotto.domain.util.RateOfReturnCalculator
import lotto.domain.util.const.lottoPrice
import lotto.domain.util.validations.LottoBonusNumbersValidator
import lotto.domain.util.validations.LottoNumbersValidator
import lotto.domain.util.validations.PriceValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private var numberOfTickets = 0
    private val lottos = mutableListOf<Lotto>()
    private lateinit var userLottos: Lotto
    private var userBonusNumber = 0
    private val winnings = Winning.values()

    fun showWinningNumbers() {
        lottos.forEach {
            it.printWinningNumbers()
        }
    }

    fun getPurchasePrice(): String {
        OutputView.printPriceMessage()
        return InputView.inputPrice()
    }

    fun getNumberOfTickets(purchasePrice: String) {
        val tickets = purchasePrice.toIntOrNull()
        if (PriceValidator.inputPrice(purchasePrice)) {
            OutputView.printLottoCountMessage(tickets!! / lottoPrice)
            numberOfTickets = tickets / lottoPrice
        }
    }

    fun getWinningNumbers() {
        repeat(numberOfTickets) {
            val numbers = NumberPicker.pickNumbers()
            Lotto(numbers).apply {
                lottos.add(this)
            }
        }
    }

    fun getUserNumbers(): String {
        return InputView.inputNumbers()
    }

    fun validateUserNumbers(userInputNumbers: String) {
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

    fun getUserBonusNumber(): String {
        return InputView.inputBonusNumber()
    }

    fun validateUserBonusNumber(userInputBonusNumber: String) {
        if (LottoBonusNumbersValidator.inputNumber(userLottos, userInputBonusNumber)) {
            userInputBonusNumber.toInt().apply {
                userBonusNumber = this
            }
        }
    }

    fun checkWinning() {
        lottos.forEach {
            val winningResult = it.checkWinning(userLottos, userBonusNumber)
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
        return RateOfReturnCalculator.calculateRateOfReturn(totalWinningPrice, numberOfTickets)
    }

    fun showRateOfReturn(totalRateOfReturn: String) {
        OutputView.printTotalRateOfReturnMessage(totalRateOfReturn)
    }

}