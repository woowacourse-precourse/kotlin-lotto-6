package lotto.controller

import lotto.model.Ball
import lotto.model.Lotto
import lotto.model.LottoPrizeCalculator
import lotto.model.PrizeReceipt
import lotto.model.seller.LottoSeller
import lotto.model.seller.Ticket
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val outputView: OutputView, private val inputView: InputView) {

    fun start() {
        runCatching {
            val ticket = issueLottoTicket()
            outputView.printLottoTicket(ticket)

            val receipt = calculatePrize(ticket)
            outputView.printResult(receipt)
        }.onFailure { throwable ->
            outputView.printError(throwable.message)
        }.also {
            inputView.terminated()
        }
    }

    private fun issueLottoTicket(): Ticket {
        val lottoSeller = LottoSeller()
        return lottoSeller.issueLottoTicket(getMoneyInput())
    }

    private fun calculatePrize(ticket: Ticket): PrizeReceipt {
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonus()
        val lottoPrizeCalculator = LottoPrizeCalculator(winningNumbers, bonusNumber)
        return lottoPrizeCalculator.issueLottoResultReceipt(ticket)
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