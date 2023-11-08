package lotto

import lotto.domain.Lotto
import lotto.domain.NumberGenerator
import lotto.domain.LottoWinResult
import lotto.ui.LottoView

fun main() {
    val numberGenerator = NumberGenerator()
    val lottoView = LottoView()

    val tickets = mutableListOf<List<Int>>()

    val ticketPrice = lottoView.getTicketPrice()
    val ticketCount = lottoView.calculateTicketCount(ticketPrice.toInt())

    lottoView.showPurchasedTicketCount(ticketCount)

    repeat(ticketCount) { index ->
        val randomNumbers = numberGenerator.createRandomNumbers()
        tickets.add(randomNumbers)

        println(tickets[index])
    }

    val luckyNumbers = lottoView.getLuckyNumbers()
    val bonusNumber = lottoView.getBonusNumber()
    lottoView.closeConsole()

    tickets.forEach { numbers ->
        val lotto = Lotto(numbers)
        val ball = lotto.matchNumbers(luckyNumbers)
        val bonus = lotto.hasBonusNumber(bonusNumber)

        with(LottoWinResult) {
            calculateRank(ball, bonus)
            addPrizeMoney(ball, bonus)
        }
    }

    with(lottoView) {
        showOverviewWinResult()
        showWinResult(LottoWinResult.getRanks())
    }

    val rateOfProfit = LottoWinResult.calculateRateOfProfit(ticketPrice.toInt(), LottoWinResult.getMoney())
    lottoView.showRateOfProfit(rateOfProfit)

    lottoView.closeConsole()
}
