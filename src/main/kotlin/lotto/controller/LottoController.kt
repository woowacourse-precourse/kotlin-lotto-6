package lotto.controller

import lotto.model.Bonus
import lotto.model.Lotto
import lotto.model.LottoPrizeCalculator
import lotto.model.PrizeReceipt
import lotto.model.seller.LottoSeller
import lotto.model.seller.Ticket
import lotto.view.InputView
import lotto.view.OutputView
import kotlin.IllegalArgumentException

class LottoController(private val outputView: OutputView, private val inputView: InputView) {

    fun start() {
        val ticket = issueLottoTicket()
        outputView.printLottoTicket(ticket)

        val receipt = calculatePrize(ticket)
        outputView.printResult(receipt)

        inputView.terminated()
    }

    private fun issueLottoTicket(): Ticket {
        val lottoSeller = LottoSeller()
        outputView.printPaymentAmountInput()
        return getTicket(lottoSeller)
    }

    private fun calculatePrize(ticket: Ticket): PrizeReceipt {
        outputView.printWinningNumbersInput()
        val winningNumbers = getWinningNumbers()
        outputView.printBonusInput()
        val bonusNumber = getBonus(winningNumbers)
        val lottoPrizeCalculator = LottoPrizeCalculator(winningNumbers, bonusNumber)
        return lottoPrizeCalculator.issueLottoResultReceipt(ticket)
    }

    private fun getTicket(seller: LottoSeller): Ticket =
        runCatching<Ticket> {
            val input = inputView.getUserInput()
            return seller.issueLottoTicket(input)
        }.onFailure { throwable ->
            if (throwable is IllegalArgumentException) {
                outputView.printError(throwable.message)
                return getTicket(seller)
            }
        }.getOrThrow()

    private fun getBonus(winningNumbers: Lotto): Bonus =
        runCatching<Bonus> {
            return Bonus.of(inputView.getUserInput(), winningNumbers)
        }.onFailure { throwable ->
            if (throwable is IllegalArgumentException) {
                outputView.printError(throwable.message)
                return getBonus(winningNumbers)
            }
        }.getOrThrow()

    private fun getWinningNumbers(): Lotto =
        runCatching<Lotto> {
            return Lotto.create(inputView.getUserInput())
        }.onFailure { throwable ->
            if (throwable is IllegalArgumentException) {
                outputView.printError(throwable.message)
                return getWinningNumbers()
            }
        }.getOrThrow()
}