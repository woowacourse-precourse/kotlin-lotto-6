package lotto.presentation.viewmodel

import lotto.domain.enum.winning.MatchCountPrize
import lotto.domain.model.Customer
import lotto.domain.model.Winning
import lotto.domain.service.LottoCalculator
import lotto.domain.service.LottoService
import lotto.domain.service.WinningCalculator

class LottoViewModel {
    lateinit var winning: Winning
    lateinit var customer: Customer
    val lottoCalculator = LottoCalculator(winning)
    val lottoService = LottoService()
    val winningCalculator = WinningCalculator(winning,customer)

    fun initialWinning(winningNumbers:List<Int>,bonusNumber:Int){
        winning = Winning(winningNumbers,bonusNumber)
    }

    fun initialCustomer(){
        customer = Customer()
    }

    fun formatWinningResult(): String {
        var result = ""
        val winningRanks = winningCalculator.getWinningRanks()
        var matchCount = 3
        for (rank in 5 downTo 1) {
            result += getMatchLotto(matchCount, winningRanks[rank] ?: 0)
            if (matchCount == 5) continue
            matchCount++
        }
        return result
    }

    fun formatTotalReturnPercent() = String.format("%.1f%%", winningCalculator.getTotalReturnPercent())

    private fun getMatchLotto(matchCount: Int, rankCount: Int): String {
        if (matchCount == 5 && rankCount == 2) {
            return "${matchCount}개 일치, 보너스 볼 일치 (${formatCurrency(getPrizes(matchCount, false))}) - $rankCount \n"
        }
        return "${matchCount}개 일치 (${formatCurrency(getPrizes(matchCount, false))}) - $rankCount \n"
    }


    private fun formatCurrency(price: Int) = String.format("%,.0f원", price.toDouble())

    private fun getPrizes(matchCount: Int, hasMatchBonus: Boolean): Int {
        return when (matchCount) {
            MatchCountPrize.FIRST.matchCount -> MatchCountPrize.FIRST.amount
            MatchCountPrize.SECOND.matchCount -> if (hasMatchBonus) MatchCountPrize.SECOND.amount else MatchCountPrize.THIRD.amount
            MatchCountPrize.FOURTH.matchCount -> MatchCountPrize.THIRD.amount
            MatchCountPrize.FIFTH.matchCount -> MatchCountPrize.FOURTH.amount
            else -> MatchCountPrize.FIFTH.amount
        }
    }

}