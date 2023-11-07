package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult

class OutputView {
    fun printLottoPurchaseReceipt(lottos: List<Lotto>) {
        println("\n${lottos.size}개를 구매했습니다.")
        printLottoNumbers(lottos)
    }

    private fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto)
        }
    }

    fun printWinningStatistics(lottoResult: LottoResult) {
        println()
        println("당첨 통계")
        println("---")
        print(lottoResult)
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 %.1f%%입니다.".format(rateOfReturn))
    }
}