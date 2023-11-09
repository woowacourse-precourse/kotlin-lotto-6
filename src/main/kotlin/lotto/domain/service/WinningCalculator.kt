package lotto.domain.service

import lotto.domain.enum.number.UnitNumber
import lotto.domain.enum.winning.RankPrize
import lotto.domain.model.Customer
import lotto.domain.model.Winning

class WinningCalculator(private val winning: Winning, private val customer: Customer) {
    val lottoCalculator = LottoCalculator(winning)
    fun getWinningRanks(): MutableMap<Int, Int> {
        val result = mutableMapOf<Int, Int>()
        customer.lotteries.forEach { lotto ->
            val lottoRank = lottoCalculator.checkWinningRank(lotto)
            result[lottoRank] = result.getOrDefault(lottoRank, INITIAL_NUMBER) + COUNT
        }
        return result
    }

    fun getTotalReturnPercent(): Double {
        val price = customer.lotteries.size.times(UnitNumber.LOTTO_PRICE.number)
        return (getTotalReturn() / price) * UnitNumber.PERCENT.number
    }

    private fun getTotalReturn(): Double {
        var result = 0.0
        getWinningRanks().forEach { (rank, count) ->
            result += getPrizes(rank).times(count)
        }
        return result
    }

    private fun getPrizes(rank: Int): Int {
        return when (rank) {
            RankPrize.FIRST.rank -> RankPrize.FIRST.amount
            RankPrize.SECOND.rank -> RankPrize.SECOND.amount
            RankPrize.THIRD.rank -> RankPrize.THIRD.amount
            RankPrize.FOURTH.rank -> RankPrize.FOURTH.amount
            RankPrize.FIFTH.rank -> RankPrize.FIFTH.amount
            else -> RankPrize.NOT.amount
        }
    }

    companion object{
        const val INITIAL_NUMBER = 0
        const val COUNT = 1
    }
}