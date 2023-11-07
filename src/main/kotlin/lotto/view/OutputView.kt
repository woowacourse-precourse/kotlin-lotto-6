package lotto.view

import lotto.domain.lotto.Lottos
import lotto.domain.winningResult.WinningResult

object OutputView {

    private const val OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다."
    private const val OUTPUT_TITLE_WINNING_RESULT = "당첨 통계"
    private const val OUTPUT_WINNING_RESULT_SEPARATOR = "---"

    fun outputLottos(lottos: Lottos) {
        println()
        println(OUTPUT_LOTTO_COUNT.format(lottos.size()))
        println(lottos.joinToString(System.lineSeparator()))
    }

    fun outputWinningResult(winningResult: WinningResult) {
        println()
        println(OUTPUT_TITLE_WINNING_RESULT)
        println(OUTPUT_WINNING_RESULT_SEPARATOR)
        println(winningResult)
    }
}