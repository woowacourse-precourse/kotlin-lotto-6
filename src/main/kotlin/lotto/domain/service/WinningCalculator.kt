package lotto.domain.service

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
}