package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import java.math.BigDecimal
import java.math.RoundingMode

class LottoRepository {
    fun generateAutoLottoTickets(lottoTicketsNum: Int): List<Lotto> {
        val tickets = buildList<Lotto>(lottoTicketsNum) {
            repeat(lottoTicketsNum){
                generateLotto()
            }
        }
        return tickets
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).toList().sorted()
        return Lotto(numbers)
    }

    fun calculateLottoResult(
        lottoTicketsNum: Int,
        autoLottoTickets: List<Lotto>,
        winningLottoInfo: Lotto,
        bonusInfo: Int
    ): Pair<List<Int>, Double> {
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

    private fun calculateReturnRate(lottoTicketsNum: Int, ranks: List<Int>): Double {
        var result = BigDecimal.valueOf(0)
        ranks.forEachIndexed { idx, it ->
            result += BigDecimal.valueOf(getMoneyByRank(idx) * it)
        }
        result = result.divide(BigDecimal(lottoTicketsNum * 10), 2, RoundingMode.HALF_UP)

        return result.toDouble()
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
