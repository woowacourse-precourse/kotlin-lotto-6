package lotto

import java.text.DecimalFormat

class LottoResult(private val lottoTickets: LottoTickets, private val winningLotto: WinningLotto) {

    private var winningResults: List<Prize> = listOf()

    fun createResult() = calculateWinningResults()

    private fun calculateWinningResults() {
        val matchedNumbersCounts = calculateMatchedNumberCounts(winningLotto)
        val bonusNumberExists = checkForBonusNumber(winningLotto)
        winningResults = List(lottoTickets.tickets.size) { index ->
            Prize.findPrizeResult(matchedNumbersCounts[index], bonusNumberExists[index])
        }
    }

    private fun calculateMatchedNumberCounts(winningLotto: WinningLotto): List<Int> = lottoTickets.tickets.map { it.countMatchingNumbers(winningLotto.winningNumbers) }
    private fun checkForBonusNumber(winningLotto: WinningLotto): List<Boolean> = lottoTickets.tickets.map { it.hasBonusNumber(winningLotto.bonusNumber) }

    fun displayResult() {
        displayWinningResults()
        displayWinningProfitRate()
    }

    private fun displayWinningResults() {
        println(InfoMessage.WIN_STATICS.message)
        println(InfoMessage.STATICS_DIVIDER.message)
        printWinningResult()
    }

    private fun printWinningResult() {
        val prizes = Prize.values().filterNot { it == Prize.NOTHING }.reversed()
        prizes.forEach { printEachWinningResult(it) }
    }

    private fun printEachWinningResult(prize: Prize) {
        val message = winCountMessage(
                matchedNumberCount = findMatchedNumberCount(prize),
                bonusInfo = bonusInfoMessage(prize),
                winningPrizeMoney = prize.amount.toWonFormat(),
                winTicketCount = findWinTicketCount(prize)
        )
        println(message)
    }

    private fun winCountMessage(
            matchedNumberCount: Int,
            bonusInfo: String,
            winningPrizeMoney: String,
            winTicketCount: Int
    ): String = "${matchedNumberCount}개 일치${bonusInfo}(${winningPrizeMoney}원) - ${winTicketCount}개"

    private fun findMatchedNumberCount(prize: Prize) = WinningBallCount.findPrizeBallCount(prize)
    private fun bonusInfoMessage(prize: Prize): String = if (prize == Prize.SECOND) InfoMessage.BONUS_NUMBER_MATCH.message else " "
    private fun Int.toWonFormat(): String = DecimalFormat("#,###").format(this)
    private fun findWinTicketCount(prize: Prize) = winningResults.count { it == prize }

    private fun displayWinningProfitRate() = println(InfoMessage.TOTAL_PROFIT.message.format(calculateTotalStaticsResult()))

    private fun calculateTotalStaticsResult(): Double {
        val prizeCountMap = winningResults.groupingBy { it }.eachCount()
        val totalProfit = prizeCountMap.map { it.key.amount * it.value }.sum()
        val payment = lottoTickets.tickets.count() * 1_000
        return (totalProfit.toDouble() / payment) * 100.0
    }
}