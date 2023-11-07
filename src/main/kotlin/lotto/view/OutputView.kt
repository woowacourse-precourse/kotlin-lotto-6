package lotto.view

class OutputView {

    fun printLottoCount(lottoCount: Int) {
        println(String.format(LOTTO_COUNT, lottoCount))
    }

    fun printLottoResult(
        threeMatch: Int,
        fourMatch: Int,
        fiveMatch: Int,
        bonusMatch: Int,
        sixMatch: Int,
        earningRate: Double,
    ) {
        println(MATCH_COUNT_TITLE)
        println(String.format(MATCH_COUNT, threeMatch, fourMatch, fiveMatch, bonusMatch, sixMatch, earningRate))
    }

    companion object {
        const val LOTTO_COUNT = "\n%d개를 구매했습니다."
        const val MATCH_COUNT_TITLE = "\n당첨 통계\n---"
        const val MATCH_COUNT = "3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개\n" +
                "총 수익률은 %.1f%%입니다."
    }
}