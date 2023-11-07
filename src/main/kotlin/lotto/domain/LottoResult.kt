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
        println("\n--- 당첨 통계 ---")
        resultLottos.filterKeys { it != LottoRank.OUT_OF_RANK }.forEach { (key, value) ->
            println("${key.toString()} - ${value}개")
        }
    }

    fun computerProfit(cost: Int) :Double{
        val lottoProfit = (totalPrize.toDouble() / cost.toDouble()) * 100
        profit = "%.1f".format(lottoProfit).toDouble()
        return profit
    }

    fun printProfit() {
        println("총 수익률은 $profit%입니다. ")
    }
}