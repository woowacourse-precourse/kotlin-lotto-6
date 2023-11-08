package lotto.controller

import lotto.constant.Constants.MAX_ATTEMPTS
import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.LottoStore
import lotto.validator.BonusNumberValidator
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
        var attempts = 0
        while (attempts <= MAX_ATTEMPTS) {
            try {
                val purchasePrice = InputView.promptForPurchasePrice().also { println() }
                return Pair(LottoStore(purchasePrice), purchasePrice.toInt())
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

    private fun issueTickets(lottoStore: LottoStore): List<Lotto> {
        val tickets = lottoStore.sellTickets()
        OutputView.purchaseCount(lottoStore.getNumberOfTickets())
        OutputView.ticketDetails(tickets).also { println() }
        return tickets
    }

    private fun inputWinNumbers(): List<Int> {
        var attempts = 0
        while (attempts <= MAX_ATTEMPTS) {
            try {
                val winNumbers = InputView.promptForWinNumbers().also { println() }
                WinNumbersValidator(winNumbers)
                return winNumbers.map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

    private fun inputBonusNumber(winNumbers: List<Int>): Int {
        var attempts = 0
        while (attempts <= MAX_ATTEMPTS) {
            try {
                val bonusNumber = InputView.promptForBonusNumber().also { println() }
                BonusNumberValidator(winNumbers, bonusNumber)
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
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
