package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.GRADE
import lotto.data.Lotto
import lotto.data.Stats
import lotto.data.WinningLotto
import kotlin.math.round

class PointOfSales : RetryUntilSuccess() {

    fun issueLotto(quantity: Int): List<Lotto> {
        require(quantity > 0) {
            QUANTITY_SHOULD_BE_MORE_THEN_0
        }
        val tickets = mutableListOf<Lotto>()
        repeat(quantity) {
            tickets.add(Lotto(getRandomLottoNum()))
        }
        return tickets.toList()
    }

    fun getQuotientAndRemainder(dividend: UInt, divisor: UInt): Pair<Int, Int> {
        val quotient = (dividend / divisor).toInt()
        val remainder = (dividend % divisor).toInt()

        return quotient to remainder
    }

    fun checkResultOfLotto(tickets: List<Lotto>): Stats {
        val winningLotto = getWinningLotto()

        return calculateStats(tickets, winningLotto)
    }

    private fun getWinningLotto(): WinningLotto {
        val nums = doUntilSuccess { IO.getInstance().getWinningLottoNum() }
        val bonus = doUntilSuccess { IO.getInstance().getBonusNum(nums) }
        return executeOrFallback(
            primary = { WinningLotto(nums, bonus) },
            fallback = { getWinningLotto() },
        )
    }

    private fun calculateStats(tickets: List<Lotto>, winningLotto: WinningLotto): Stats {
        val countOfWin = IntArray(6) { 0 }
        for (ticket in tickets) {
            countOfWin[ticket.checkGrade(winningLotto).rank()]++
        }
        return Stats(
            first = countOfWin[1],
            second = countOfWin[2],
            third = countOfWin[3],
            fourth = countOfWin[4],
            fifth = countOfWin[5],
            profitRate = calculateProfitRate(countOfWin, tickets.size)
        )
    }

    private fun calculateProfitRate(countOfWin: IntArray, countOfBuying: Int): Float {
        val totalProfit = countOfWin.reduceIndexed { rank: Int, sum: Int, count: Int ->
            if (rank == 0) {
                return@reduceIndexed sum
            }
            sum + GRADE.fromRank(rank).price() * count
        }
        return round((totalProfit.toFloat() / (Lotto.PRICE.toFloat() * countOfBuying) * ROUND_FACTOR)) / PERCENT_CONVERSION_FACTOR
    }

    private fun getRandomLottoNum() =
        Randoms.pickUniqueNumbersInRange(Lotto.START_NUM, Lotto.END_NUM, Lotto.LENGTH_OF_NUM).sorted()

    companion object {
        const val QUANTITY_SHOULD_BE_MORE_THEN_0 = "[ERROR] 구매 수량은 1개 이상이어야 합니다."
        private const val ROUND_FACTOR = 1_000f
        private const val PERCENT_CONVERSION_FACTOR = 10f
    }
}