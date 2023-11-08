package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult {

    fun calculateLottoResult(
        lottoTicketsNum: Int,
        autoLottoTickets: List<Lotto>,
        winningLottoInfo: Lotto,
        bonusInfo: Int
    ): Pair<List<Int>, String> {
        val ranks = calculateLottos(autoLottoTickets, winningLottoInfo, bonusInfo)
        val returnRate = calculateReturnRate(lottoTicketsNum, ranks)
        return Pair(ranks, returnRate)
    }

    private fun calculateLottos(autoLottoTickets: List<Lotto>, winningLottoInfo: Lotto, bonusInfo: Int): List<Int> {
        val ranks = IntArray(6)
        autoLottoTickets.forEach {
            ranks[it.getRanks(winningLottoInfo, bonusInfo)]++
        }
        return ranks.toList()
    }

    private fun calculateReturnRate(lottoTicketsNum: Int, ranks: List<Int>): String {
        var result = BigDecimal.valueOf(0)
        ranks.forEachIndexed { idx, it ->
            result += BigDecimal.valueOf(getMoneyByRank(idx) * it)
        }
        result = result.divide(BigDecimal(lottoTicketsNum * 10), 2, RoundingMode.HALF_UP)

        return result.toString()
    }

    private fun getMoneyByRank(idx: Int): Long {
        when(idx){
            1 -> return 2000000000
            2 -> return 30000000
            3 -> return 1500000
            4 -> return 50000
            5 -> return 5000
        }
        return 0
    }
}
