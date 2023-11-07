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
        println(PRINT_RESULT_STRING)
        println(PRINT_TRIPLE_MINUS)
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

    fun printLottoCount(count: Int) {
        println(LOTTO_COUNT_STRING.format(count))
    }

    fun printTotalProfit(priceAmount: Int, totalPrize: Long) {
        val profit = (totalPrize.toDouble() / priceAmount.toDouble())
        val result = (Math.round(profit * 1000) / 10.0)
        print(PRINT_PROFIT_STRING.format(result))
    }

    companion object {
        const val PRINT_PROFIT_STRING = "총 수익률은 %.1f%%입니다."
        const val PRINT_RESULT_STRING = "당첨 통계"
        const val PRINT_TRIPLE_MINUS = "---"
        const val LOTTO_COUNT_STRING = "%d개를 구매했습니다."
    }
}