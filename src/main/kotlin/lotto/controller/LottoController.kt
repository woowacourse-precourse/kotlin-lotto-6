package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.LottoStore
import lotto.validator.BonusNumberValidator
import lotto.validator.InputValidator
import lotto.validator.PurchasePriceValidator
import lotto.validator.WinNumbersValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val (lottoStore, purchasePrice) = inputPrice()
        val tickets: List<Lotto> = issueTickets(lottoStore)
        val winNumbers: List<Int> = inputWinNumbers()
        val bonusNumber: Int = inputBonusNumber(winNumbers)
        val results: List<LottoRank> = calculateResult(tickets, winNumbers, bonusNumber)

        printPrizeDetails(results)
        printRateOfReturn(results, purchasePrice)
    }

    private fun inputPrice(): Pair<LottoStore, Int> {
        val purchasePrice = InputValidator().inputWithRetry(
            prompt = { InputView.promptForPurchasePrice() },
            validator = { PurchasePriceValidator(it) }
        )
        return Pair(LottoStore(purchasePrice), purchasePrice.toInt())
    }

    private fun issueTickets(lottoStore: LottoStore): List<Lotto> {
        val tickets = lottoStore.sellTickets()
        OutputView.purchaseCount(lottoStore.getNumberOfTickets())
        OutputView.ticketDetails(tickets).also { println() }
        return tickets
    }

    private fun inputWinNumbers(): List<Int> {
        val winNumbers = InputValidator().inputWithRetry(
            prompt = { InputView.promptForWinNumbers() },
            validator = { WinNumbersValidator(it) }
        )
        return winNumbers.map { it.toInt() }
    }

    private fun inputBonusNumber(winNumbers: List<Int>): Int {
        val bonusNumber = InputValidator().inputWithRetry(
            prompt = { InputView.promptForBonusNumber() },
            validator = { BonusNumberValidator(winNumbers, it) }
        )
        return bonusNumber.toInt()
    }

    private fun calculateResult(tickets: List<Lotto>, winNumbers: List<Int>, bonusNumber: Int): List<LottoRank> {
        val results = mutableListOf<LottoRank>()
        for (ticket in tickets) {
            val matchCount = ticket.matchCount(winNumbers)
            val hasBonus = ticket.matchBonusNumber(bonusNumber)
            val prize = LottoRank.getRank(matchCount, hasBonus)
            results.add(prize)
        }
        return results
    }

    private fun printPrizeDetails(results: List<LottoRank>) {
        val ranks = LottoRank.entries.filter { it.matchCount > 0 }
        OutputView.prizeDetails(results, ranks)
    }

    private fun printRateOfReturn(results: List<LottoRank>, purchasePrice: Int) {
        val rateOfReturn = LottoResult().calculateRateOfReturn(results, purchasePrice)
        OutputView.rateOfReturn(rateOfReturn)
    }
}
