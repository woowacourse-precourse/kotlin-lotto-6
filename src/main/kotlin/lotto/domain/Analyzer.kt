package lotto.domain

import lotto.data.*


class Analyzer(private val calculator: Calculator) {

    fun getStats(tickets: List<Lotto>, winningLotto: WinningLotto): Stats {
        val resultOfTickets = checkEachTicketResult(tickets, winningLotto)
        val totalProfit = calculator.calculateTotalProfit(resultOfTickets)
        return Stats(
            info = WinningInfo.from(resultOfTickets),
            profitRate = calculator.calculateProfitRate(totalProfit, tickets.size)
        )
    }

    private fun checkEachTicketResult(tickets: List<Lotto>, winningLotto: WinningLotto): List<Int> {
        val countOfWin = IntArray(GRADE.entries.size)
        for (ticket in tickets) {
            countOfWin[ticket.checkGrade(winningLotto).rank().index]++
        }
        return countOfWin.toList()
    }
}