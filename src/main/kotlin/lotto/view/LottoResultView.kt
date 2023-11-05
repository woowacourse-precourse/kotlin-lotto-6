package lotto.view

class LottoResultView {
    fun printLottoStatistics(resultTable:Map<String, Int> ) {
        println(LOTTO_STATISTICS)
        println(LotteryPrize.FIFTH.getMessage(resultTable[GRADE_FIFTH]!!))
        println(LotteryPrize.FORTH.getMessage(resultTable[GRADE_FORTH]!!))
        println(LotteryPrize.THIRD.getMessage(resultTable[GRADE_THIRD]!!))
        println(LotteryPrize.SECOND.getMessage(resultTable[GRADE_SECOND]!!))
        println(LotteryPrize.FIRST.getMessage(resultTable[GRADE_FIRST]!!))
    }

    fun printRateReturn(gradeResult: Map<String, Int> ,money: Int) {
        val totalPrize = getTotalPrize(gradeResult)
        val rateReturn = getRateReturn(totalPrize, money)
        println(RATE_RETURN.format(rateReturn))
    }

    private fun getTotalPrize(resultTable: Map<String, Int>): Int {
        var total = 0
        resultTable.forEach {
            when(it.key) {
                GRADE_FIRST -> total += it.value * LotteryPrize.FIRST.getPrizeAmount()
                GRADE_SECOND -> total += it.value * LotteryPrize.SECOND.getPrizeAmount()
                GRADE_THIRD -> total += it.value * LotteryPrize.THIRD.getPrizeAmount()
                GRADE_FORTH -> total += it.value * LotteryPrize.FORTH.getPrizeAmount()
                GRADE_FIFTH -> total += it.value * LotteryPrize.FIFTH.getPrizeAmount()
            }
        }
        return total
    }

    private fun getRateReturn(totalPrize: Int, money: Int): Double {
        return DEFAULT_RATE - 100.0 * (money - totalPrize) / money.toDouble()
    }

    private enum class LotteryPrize(private val formatString: String, private val prizeAmount: Int) {
        FIRST("6개 일치 (2,000,000,000원) - %d개", 2000000000),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
        THIRD("5개 일치 (1,500,000원) - %d개", 1500000),
        FORTH("4개 일치 (50,000원) - %d개", 50000),
        FIFTH("3개 일치 (5,000원) - %d개", 5000);

        fun getMessage(matchedNumbers: Int): String {
            return formatString.format(matchedNumbers)
        }
        fun getPrizeAmount(): Int {
            return prizeAmount
        }
    }

    companion object {
        private const val LOTTO_STATISTICS = "\n당첨 통계\n---"
        private const val GRADE_FIRST = "FIRST"
        private const val GRADE_SECOND = "SECOND"
        private const val GRADE_THIRD = "THIRD"
        private const val GRADE_FORTH = "FORTH"
        private const val GRADE_FIFTH = "FIFTH"
        private const val RATE_RETURN = "총 수익률은 %.1f%%입니다."
        private const val DEFAULT_RATE = 100.0
    }
}