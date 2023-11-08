package lotto.view

import lotto.domain.LottoPrice

class OutputView {

    fun printLottoCount(lottoCount: Int) {
        println(String.format(LOTTO_COUNT, lottoCount))
    }

    fun printLottoResult(matchCounts: Map<LottoPrice, Int>, earningRate: Double) {
        println(MATCH_COUNT_TITLE)
        LottoPrice.values().forEach {
            val count = matchCounts[it] ?: 0
            println(String.format(MATCH_COUNTS[it] ?: "", count))
        }
        println(String.format(EARNING_RATE, earningRate))
    }

    companion object {
        const val LOTTO_COUNT = "\n%d개를 구매했습니다."
        const val MATCH_COUNT_TITLE = "\n당첨 통계\n---"
        const val EARNING_RATE = "총 수익률은 %.1f%%입니다."

        val MATCH_COUNTS: Map<LottoPrice, String> = mapOf(
            LottoPrice.THREE_MATCH to "3개 일치 (5,000원) - %d개",
            LottoPrice.FOUR_MATCH to "4개 일치 (50,000원) - %d개",
            LottoPrice.FIVE_MATCH to "5개 일치 (1,500,000원) - %d개",
            LottoPrice.BONUS_MATCH to "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
            LottoPrice.SIX_MATCH to "6개 일치 (2,000,000,000원) - %d개"
        )
    }
}