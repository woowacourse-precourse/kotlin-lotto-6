package lotto.domain

import lotto.Lotto

class LottoResult(private val lottos: List<Lotto>, private val winningNumberSet: Pair<List<Int>, Int>) {
    private var profit: Double = 0.0
    var resultLottos: MutableMap<LottoRank, Int> = mutableMapOf()
    var totalPrize: Long = 0L

    init {
        calculateResult()
    }

    private fun calculateResult() {
        LottoRank.entries.forEach { resultLottos[it] = 0 }
        for (lotto in lottos) {
            val compareResult = lotto.compareNumber(winningNumberSet)
            val lottoRank = LottoRank.fromMatches(compareResult.first, compareResult.second)
            if (lottoRank != LottoRank.OUT_OF_RANK) {
                resultLottos[lottoRank] = resultLottos.getOrDefault(lottoRank, 0) + 1
                totalPrize += lottoRank.prize.toLong()
            }
        }
    }

    fun printResultStatistics() {
        println(RESULT_STATISTICS_HEADER)
        resultLottos.filterKeys { it != LottoRank.OUT_OF_RANK }.forEach { (key, value) ->
            println(RANK_MESSAGE_FORMAT.format(key.toString(), value))
        }
    }

    fun computeProfit(cost: Int): Double {
        val lottoProfit = (totalPrize.toDouble() / cost.toDouble()) * 100
        profit = "%.1f".format(lottoProfit).toDouble()
        return profit
    }

    fun printProfit() {
        println(TOTAL_PROFIT_MESSAGE.format(profit))
    }

    companion object {
        private const val RESULT_STATISTICS_HEADER = "\n당첨 통계\n---"
        private const val RANK_MESSAGE_FORMAT = "%s - %d개"
        private const val TOTAL_PROFIT_MESSAGE = "총 수익률은 %s%%입니다."
    }
}