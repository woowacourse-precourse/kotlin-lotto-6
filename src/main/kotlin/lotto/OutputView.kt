package lotto

enum class LottoResultPrize(val prize: String) {
    THREE_MATCH("3개 일치 (5,000원)"),
    FOUR_MATCH("4개 일치 (50,000원)"),
    FIVE_MATCH("5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH("6개 일치 (2,000,000,000원)")
}

class OutputView {
    fun printOneLotto(oneLotto: List<Int>) {
        println("[${oneLotto.joinToString(", ")}]")
    }

    fun printLottoResult(lottoResult: List<Int>) {
        println("당첨 통계")
        println("---")
        for (i in 3..7) {
            val result = when (i) {
                3 -> LottoResultPrize.THREE_MATCH
                4 -> LottoResultPrize.FOUR_MATCH
                5 -> LottoResultPrize.FIVE_MATCH
                6 -> LottoResultPrize.FIVE_MATCH_WITH_BONUS
                7 -> LottoResultPrize.SIX_MATCH
                else -> null
            }
            val count = lottoResult[i]
            if (result != null) {
                println("${result.prize} - ${count}개")
            }
        }
    }

    fun printTotalProfit(priceAmount: Int, totalPrize: Long) {
        val profit = (totalPrize.toDouble() / priceAmount.toDouble())
        val result = (Math.round(profit * 1000) / 10.0)
        print("총 수익률은 $result%입니다.")
    }
}