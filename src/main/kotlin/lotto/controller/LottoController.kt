package lotto.controller

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
        val tickets : List<Lotto> = issueTickets(lottoStore)
        val winNumbers: List<Int> = inputWinNumbers()
        val bonusNumber: Int = inputBonusNumber()
        val results : List<LottoRank> = calculateResult(tickets, winNumbers, bonusNumber)

        printPrizeDetails(results)
        printRateOfReturn(results, purchasePrice)
    }

    private fun inputPrice(): Pair<LottoStore, Int> {
        var attempts = 0
        while (attempts <= 5) {
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
        OutputView.printPurchaseCount(lottoStore.getNumberOfTickets())

        val tickets = lottoStore.sellTickets()
        OutputView.printTickets(tickets).also { println() }
        return tickets
    }

    private fun inputWinNumbers(): List<Int> {
        var attempts = 0
        while (attempts <= 5) {
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

    private fun inputBonusNumber(): Int {
        var attempts = 0
        while (attempts <= 5) {
            try {
                val bonusNumber = InputView.promptForBonusNumber().also { println() }
                BonusNumberValidator(bonusNumber)
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

    private fun calculateResult(tickets: List<Lotto>, winNumbers: List<Int>, bonusNumber: Int): List<LottoRank>{
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
        OutputView.printPrizeDetails()

        LottoRank.entries.forEach { prize ->
            val count = results.count { it == prize }
            println("${prize.matchCount}개 일치${if (prize.hasBonus) ", 보너스 볼 일치 " else " "}" +
                    "(${prize.prizeMoney}원) - ${count}개")
        }
    }

    private fun printRateOfReturn(results: List<LottoRank>, purchasePrice: Int) {
        val rateOfReturn = LottoResult().calculateRateOfReturn(results, purchasePrice)
        OutputView.printRateOfReturn(rateOfReturn)
    }
}
