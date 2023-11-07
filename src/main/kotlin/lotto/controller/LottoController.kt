package lotto.controller

import lotto.model.Ball
import lotto.model.Lotto
import lotto.model.LottoPrizeCalculator
import lotto.model.seller.LottoSeller
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val outputView: OutputView, private val inputView: InputView) {

    fun start() {
        runCatching {
            val lottoSeller = LottoSeller()
            val ticket = lottoSeller.issueLottoTicket(getMoneyInput())
            outputView.printLottoTicket(ticket)

            val winningNumbers = getWinningNumbers()
            val bonusNumber = getBonus()
            val lottoPrizeCalculator = LottoPrizeCalculator(winningNumbers, bonusNumber)

            val receipt = lottoPrizeCalculator.issueLottoResultReceipt(ticket)
            outputView.printResult(receipt)
            inputView.terminated()
        }.onFailure { throwable ->
            outputView.printError(throwable.message)
        }
    }

    private fun getMoneyInput(): String {
        outputView.printPaymentAmountInput()
        return inputView.getUserInput()
    }

    private fun getBonus(): Ball {
        outputView.printBonusInput()
        return Ball(inputView.getUserInput())
    }

    private fun getWinningNumbers(): Lotto {
        outputView.printWinningNumbersInput()
        return Lotto.create(inputView.getUserInput())
    }
}