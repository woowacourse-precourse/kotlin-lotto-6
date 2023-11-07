package lotto

import lotto.domain.Lotto
import lotto.domain.LottoWinResult
import lotto.domain.NumberGenerator
import lotto.ui.LottoView

fun main() {
    val numberGenerator = NumberGenerator()
    val lottoView = LottoView()
    val winResult = LottoWinResult()

    val tickets = mutableListOf<List<Int>>()

    val ticketPrice = lottoView.askPurchaseTickets()
    val ticketCount = lottoView.calculateTicketCount(ticketPrice.toInt())

    lottoView.showPurchasedTicketCount(ticketCount)

    repeat(ticketCount) { index ->
        val randomNumbers = numberGenerator.createRandomNumbers()
        tickets.add(randomNumbers)

        println(tickets[index])
    }

    val luckyNumbers = lottoView.askLuckyNumbers()
    val bonusNumber = lottoView.askBonusNumber()

    tickets.forEach { numbers ->
        val lotto = Lotto(numbers)
        val ball = lotto.matchNumbers(luckyNumbers)
        val bonus = lotto.hasBonusNumber(bonusNumber)

        with(winResult) {
            calculateRank(ball, bonus)
            addPrizeMoney(ball, bonus)
        }
    }

    with(lottoView) {
        showOverviewWinResult()
        showWinResult(winResult.getRanks())
    }

    val rateOfProfit = winResult.calculateRateOfProfit(ticketPrice.toInt(), winResult.getTotalMoney())
    lottoView.showRateOfProfit(rateOfProfit)
}
