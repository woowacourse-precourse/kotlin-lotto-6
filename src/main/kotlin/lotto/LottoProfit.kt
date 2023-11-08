package lotto

class LottoProfit() {
    private val result = mutableListOf<Int>(0, 0, 0, 0, 0)
    fun printResult(total: List<Lotto>, purchaseLotto: Int) {
        countMatch(total)
        println("당첨 통계\n")
        println("---")
        println("3개 일치 (5,000원) - ${result[0]}개")
        println("4개 일치 (50,000원) - ${result[1]}개")
        println("5개 일치 (1,500,000원) - ${result[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[4]}개")
        println("6개 일치 (2,000,000,000원) - ${result[3]}개")
        val income =
            result[0] * RANKING_5ST + result[1] * RANKING_4ST + result[2] * RANKING_3ST + result[4] * RANKING_2ST + result[3] * RANKING_1ST
        val ratioIncome = income / (purchaseLotto.toDouble() * 1000) * 100
        println("총 수익률은 ${ratioIncome}%입니다.")
    }

    fun countMatch(total: List<Lotto>) {
        total.forEach {
            val match = it.matchingNum(LottoInput.winingNumbers, LottoInput.bonusNumber)
            if (match >= 3) result[match - 3]++
        }
    }

    companion object {
        const val RANKING_1ST = 2_000_000_000
        const val RANKING_2ST = 30_000_000
        const val RANKING_3ST = 1_500_000
        const val RANKING_4ST = 50_000
        const val RANKING_5ST = 5_000
    }
}