package lotto.domain

import lotto.Lotto

class LottoResult(private val lottos: List<Lotto>, private val winningNumbers: WinningNumber) {
    private var resultLottos: MutableMap<LottoRank, Int> = mutableMapOf()
    private var totalPrize: Long = 0L
    private var profit: Double = 0.0

    init {
        calculateResult()
    }

    private fun calculateResult() {
        LottoRank.entries.forEach { resultLottos[it] = 0 }
        for (lotto in lottos) {
            val compareResult = lotto.compareNumber(winningNumbers)
            val lottoRank = LottoRank.fromMatches(compareResult.first, compareResult.second)
            if (lottoRank != LottoRank.NO_MATCH) {
                resultLottos[lottoRank] = resultLottos.getOrDefault(lottoRank, 0) + 1
                totalPrize += lottoRank.prize.toLong()
            }
        }
    }

    fun printResultStatistics() {
        println("\n--- 당첨 통계 ---")
        resultLottos.filterKeys { it != LottoRank.NO_MATCH }.forEach { (key, value) ->
            println("${key.toString()} - ${value}개")
        }
    }

    fun computerProfit(cost: Int) {
        val lottoProfit = (totalPrize.toDouble() / cost.toDouble()) * 100
        profit = "%.1f".format(lottoProfit).toDouble()
    }

    fun printProfit() {
        println("총 수익률은 $profit%입니다. ")
    }
}