package lotto.domain

import lotto.data.GRADE
import lotto.data.Lotto
import kotlin.math.roundToInt

class Calculator {

    fun getQuotientAndRemainder(dividend: UInt, divisor: UInt): Pair<Int, Int> {
        val quotient = (dividend / divisor).toInt()
        val remainder = (dividend % divisor).toInt()

        return quotient to remainder
    }

    fun calculateTotalProfit(countOfWin: List<Int>) = countOfWin.foldIndexed(INITIAL_SUM) { indexOfRank: Int, sum: Long, count: Int ->
        sum + GRADE.from(indexOfRank).price().toLong() * count
    }

    fun calculateProfitRate(totalProfit: Long, sizeOfTicket: Int) =
        ((totalProfit.toDouble() / (Lotto.PRICE.toDouble() * sizeOfTicket) * ROUND_FACTOR)).roundToInt() / ROUND_FACTOR

    companion object {
        private const val INITIAL_SUM = 0L
        private const val ROUND_FACTOR = 1_000.0
    }
}