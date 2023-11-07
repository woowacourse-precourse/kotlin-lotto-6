package lotto

import java.text.DecimalFormat

class LottoResult(private val lottoTickets: LottoTickets, private val winningLotto: WinningLotto) {

    private var winningResult: List<Prize> = listOf()

    fun createResult() = calculateWinningResult()

    private fun calculateWinningResult() {
        val matchedNumbersCounts = calculateMatchedNumberCounts(winningLotto)
        val bonusNumberExists = checkForBonusNumber(winningLotto)
        winningResult = List(lottoTickets.tickets.size) { index ->
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
        println(WIN_STATICS)
        println(STATICS_DIVIDER)
        printWinningResult()
    }

    private fun printWinningResult() {
        val prizes = Prize.values().filterNot { it == Prize.Nothing }.reversed()
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
    ): String = "${matchedNumberCount}개 일치, ${bonusInfo}(${winningPrizeMoney})원 - ${winTicketCount}개"

    private fun findMatchedNumberCount(prize: Prize) = Prize.findPrizeMatchNumberCount(prize)
    private fun bonusInfoMessage(prize: Prize): String = if (prize == Prize.Second) BONUS_NUMBER_MATCH else ""
    private fun Int.toWonFormat(): String = DecimalFormat("#,###").format(this)
    private fun findWinTicketCount(prize: Prize) = winningResult.count { it == prize }

    private fun displayWinningProfitRate() = println(TOTAL_PROFIT.format(calculateTotalStaticsResult()))

    private fun calculateTotalStaticsResult(): Double {
        val winnerCountMap = winningResult.groupingBy { it }.eachCount()
        val totalProfit = winnerCountMap.map { it.key.amount * it.value }.sum()
        val payment = lottoTickets.tickets.count() * 1_000
        return (totalProfit.toDouble() / payment) * 100.0
    }

    companion object {
        const val WIN_STATICS = "당첨 통계"
        const val STATICS_DIVIDER = "---"
        const val BONUS_NUMBER_MATCH = "보너스 볼 일치 "
        const val TOTAL_PROFIT = "총 수익률은 %.1f%%입니다."
    }
}