package lotto.domain

import lotto.data.GRADE
import lotto.data.Lotto
import kotlin.math.round

class Calculator {

    fun getQuotientAndRemainder(dividend: UInt, divisor: UInt): Pair<Int, Int> {
        val quotient = (dividend / divisor).toInt()
        val remainder = (dividend % divisor).toInt()

        return quotient to remainder
    }

    fun calculateProfitRate(countOfWin: IntArray, countOfBuying: Int): Float {
        val totalProfit = countOfWin.reduceIndexed { rank: Int, sum: Int, count: Int ->
            if (rank == 0) {
                return@reduceIndexed sum
            }
            sum + GRADE.fromRank(rank).price() * count
        }
        return round((totalProfit.toFloat() / (Lotto.PRICE.toFloat() * countOfBuying) * ROUND_FACTOR)) / PERCENT_CONVERSION_FACTOR
    }

    companion object {
        private const val ROUND_FACTOR = 1_000f
        private const val PERCENT_CONVERSION_FACTOR = 10f
    }
}