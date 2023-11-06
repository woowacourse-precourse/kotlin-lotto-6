package lotto

import java.text.DecimalFormat

class LottoResult(private val lottoTickets: LottoTickets, private val winningLotto: WinningLotto) {

    private var winningResult: List<Prize> = listOf()

    init {
        findWinningResult()
    }

    fun printResult() {
        printWinningResults()
        printWinningProfitRate()
    }

    private fun printWinningResults() {
        println(WIN_STATICS)
        println(STATICS_DIVIDER)
        Prize.values().filterNot { it == Prize.Nothing }.reversed().forEach { displayWinningResult(it) }
    }

    private fun displayWinningResult(prize: Prize) {
        val winCount = findWindCount(prize)
        val matchedNumberCount = findMatchedNumberCount(prize)
        val winningPrizeMoney = prize.amount.toWonFormat()
        val bonusInfo = if (prize == Prize.Second) "보너스 볼 일치 " else ""
        val message = winCountMessage(matchedNumberCount, bonusInfo, winningPrizeMoney, winCount)
        println(message)
    }

    private fun findWindCount(prize: Prize) = winningResult.count { it == prize }
    private fun findMatchedNumberCount(prize: Prize) = Prize.findPrizeMatchNumberCount(prize)
    private fun Int.toWonFormat(): String = DecimalFormat("#,###").format(this)

    private fun winCountMessage(
        matchedNumberCount: Int,
        bonusInfo: String,
        winningPrizeMoney: String,
        winCount: Int
    ): String {
        return "${matchedNumberCount}개 일치, ${bonusInfo}(${winningPrizeMoney})원 - ${winCount}개"
    }

    private fun printWinningProfitRate() {
        println(TOTAL_PROFIT.format(calculateTotalStaticResult()))
    }

    private fun calculateTotalStaticResult(): Double {
        val winnerCountMap = winningResult.groupingBy { it }.eachCount()
        val totalProfit = winnerCountMap.map { it.key.amount * it.value }.sum()
        val payment = lottoTickets.tickets.count() * 1_000
        return (totalProfit.toDouble() / payment) * 100.0
    }

    private fun findWinningResult() {
        val matchedNumbersCounts = calculateMatchedNumberCounts(winningLotto)
        val bonusNumberExists = checkForBonusNumber(winningLotto)
        winningResult = List(lottoTickets.tickets.size) { index ->
            Prize.findPrizeResult(matchedNumbersCounts[index], bonusNumberExists[index])
        }
    }

    private fun calculateMatchedNumberCounts(winningLotto: WinningLotto): List<Int> {
        return lottoTickets.tickets.map { it.countMatchingNumbers(winningLotto.winningNumbers) }
    }

    private fun checkForBonusNumber(winningLotto: WinningLotto): List<Boolean> {
        return lottoTickets.tickets.map { it.hasBonusNumber(winningLotto.bonusNumber) }
    }

    companion object {
        const val WIN_STATICS = "당첨 통계"
        const val STATICS_DIVIDER = "---"
        const val TOTAL_PROFIT = "총 수익률은 %.1f%%입니다."
    }
}