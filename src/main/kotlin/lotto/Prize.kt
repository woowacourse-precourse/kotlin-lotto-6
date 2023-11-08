package lotto

class Prize(
    var count3: Int,
    var count4: Int,
    var count5: Int,
    var count5_2: Int,
    var count6: Int,
    var buy: Int,
) {

    fun printResult() {
        println(
            "3개 일치 (${MATCH_3}원) - ${count3}개\n" +
                    "4개 일치 (${MATCH_4}원) - ${count4}개\n" +
                    "5개 일치 (${MATCH_5}원) - ${count5}개\n" +
                    "5개 일치, 보너스 볼 일치 (${MATCH_5_2}원) - ${count5_2}개\n" +
                    "6개 일치 (${MATCH_6}원) - ${count6}개"
        )
    }

    fun yieldRateOfReturn() {
        val totalPrize =
            MATCH_3 * count3 + MATCH_4 * count4 + MATCH_5 * count5 + MATCH_5_2 * count5_2 + MATCH_6 * count6
        val yieldRate = (totalPrize.toDouble() / buy) * 100
        val formattedYieldRate = "%.1f".format(yieldRate)
        println("총 수익률은 ${formattedYieldRate}%입니다.")
    }

    companion object {
        const val MATCH_3 = 5000
        const val MATCH_4 = 50000
        const val MATCH_5 = 1500000
        const val MATCH_5_2 = 30000000
        const val MATCH_6 = 2000000000
    }
}