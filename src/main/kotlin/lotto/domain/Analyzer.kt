package lotto.domain

import lotto.data.*


class Analyzer(private val calculator: Calculator) {

    fun getStats(tickets: List<Lotto>, winningLotto: WinningLotto): Stats {
        val countOfWin = IntArray(GRADE.entries.size)
        for (ticket in tickets) {
            countOfWin[ticket.checkGrade(winningLotto).rank()]++
        }
        return Stats(
            info = WinningInfo.from(countOfWin.slice(1..countOfWin.size)),
            profitRate = calculator.calculateProfitRate(countOfWin, tickets.size)
        )
    }
}