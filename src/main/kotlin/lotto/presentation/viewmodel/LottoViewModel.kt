package lotto.presentation.viewmodel

import lotto.domain.enum.winning.MatchCountPrize
import lotto.domain.model.Customer
import lotto.domain.model.Winning
import lotto.domain.service.LottoCalculator
import lotto.domain.service.LottoService
import lotto.domain.service.WinningCalculator

class LottoViewModel {
    var winning: Winning = Winning(listOf(1, 2, 3, 4, 5, 6), 7)
    var customer: Customer = Customer()
    private var winningCalculator = WinningCalculator(winning, customer)

    fun initialWinning(winningNumbers: List<Int>, bonusNumber: Int) {
        winning = Winning(winningNumbers, bonusNumber)
        winningCalculator = WinningCalculator(winning, customer)
    }

    fun initialCustomer(price: Int) {
        customer = Customer()
        customer.buyLotteries(price)
    }

    fun formatWinningResult(): String {
        var result = ""
        val winningRanks = winningCalculator.getWinningRanks()
        var matchCount = 3
        for (rank in 5 downTo 1) {
            result += getMatchLotto(matchCount, winningRanks[rank] ?: 0, rank)
            if (rank == 3) continue
            matchCount++
        }
        return result
    }

    fun formatTotalReturnPercent() = String.format("%.1f%%", winningCalculator.getTotalReturnPercent())

    private fun getMatchLotto(matchCount: Int, rankCount: Int, rank: Int): String {
        if (rank == 2) {
            return "${matchCount}개 일치, 보너스 볼 일치 (${formatCurrency(getPrizes(matchCount, true))}) - ${rankCount}개 \n"
        }
        return "${matchCount}개 일치 (${formatCurrency(getPrizes(matchCount, false))}) - ${rankCount}개 \n"
    }


    private fun formatCurrency(price: Int) = String.format("%,.0f원", price.toDouble())

    private fun getPrizes(matchCount: Int, hasMatchBonus: Boolean): Int {
        return when (matchCount) {
            MatchCountPrize.FIRST.matchCount -> MatchCountPrize.FIRST.amount
            MatchCountPrize.SECOND.matchCount -> if (hasMatchBonus) MatchCountPrize.SECOND.amount else MatchCountPrize.THIRD.amount
            MatchCountPrize.FOURTH.matchCount -> MatchCountPrize.FOURTH.amount
            else -> MatchCountPrize.FIFTH.amount
        }
    }

}