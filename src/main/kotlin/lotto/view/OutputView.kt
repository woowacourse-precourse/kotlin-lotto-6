package lotto.view

class OutputView {

    fun printLottoResult(
        threeMatch: Int,
        fourMatch: Int,
        fiveMatch: Int,
        bonusMatch: Int,
        sixMatch: Int,
        earningRate: Double,
    ) {
        println(MATCH_COUNT_TITLE)
        println(String.format(MATCH_COUNT, threeMatch, fourMatch, fiveMatch, bonusMatch, sixMatch))
        println(String.format(EARNING_RATE, earningRate))
    }

    companion object {
        const val MATCH_COUNT_TITLE = "\n당첨 통계\n---"
        const val MATCH_COUNT = "3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개\n"
        const val EARNING_RATE = "총 수익률은 %.1f입니다."
    }
}