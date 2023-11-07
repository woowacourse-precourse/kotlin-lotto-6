package lotto.domain

import lotto.data.GRADE
import lotto.data.Lotto
import lotto.data.Stats
import lotto.data.WinningLotto

class Analyzer(private val calculator: Calculator) {

    fun getStats(tickets: List<Lotto>, winningLotto: WinningLotto): Stats {
        val countOfWin = IntArray(GRADE.entries.size)
        for (ticket in tickets) {
            countOfWin[ticket.checkGrade(winningLotto).rank()]++
        }
        return Stats(
            first = countOfWin[1],
            second = countOfWin[2],
            third = countOfWin[3],
            fourth = countOfWin[4],
            fifth = countOfWin[5],
            profitRate = calculator.calculateProfitRate(countOfWin, tickets.size)
        )
    }
}