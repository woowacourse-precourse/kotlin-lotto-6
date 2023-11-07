package lotto.domain.service

import lotto.domain.enum.winning.Prize
import lotto.domain.model.Customer
import lotto.domain.model.Winning

class WinningCalculator(private val winning: Winning, private val customer: Customer) {
    val lottoCalculator = LottoCalculator(winning)
    fun getWinningRanks(): MutableMap<Int, Int> {
        val result = mutableMapOf<Int, Int>()
        customer.lotteries.forEach { lotto ->
            val lottoRank = lottoCalculator.checkWinningRank(lotto)
            result[lottoRank] = result.getOrDefault(lottoRank, 0) + 1
        }
        return result
    }

    fun getTotalReturnPercent():String{
        val price = customer.lotteries.size.times(1000)
        return String.format("%.1f%%", (getTotalReturn()/price) * 100)
    }

   private fun getTotalReturn():Double{
        var result = 0.0
        getWinningRanks().forEach { (rank, count) ->
            result += getPrizes(rank).times(count)
        }
        return result
    }

    private fun getPrizes(rank:Int):Int{
        return when(rank){
            Prize.FIRST.rank -> Prize.FIRST.amount
            Prize.SECOND.rank -> Prize.SECOND.amount
            Prize.THIRD.rank -> Prize.THIRD.amount
            Prize.FOURTH.rank -> Prize.FOURTH.amount
            Prize.FIFTH.rank -> Prize.FIFTH.amount
            else -> Prize.NOT.amount
        }
    }
}