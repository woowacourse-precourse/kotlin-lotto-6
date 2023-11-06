package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Lottos

class OutputView {
    fun printLottoPurchaseReceipt(lottos: Lottos) {
        printNumberOfLottos(lottos)
        printLottoNumbers(lottos)
    }
    private fun printNumberOfLottos(lottos: Lottos) {
        println("\n${lottos.getLottos().size}개를 구매했습니다.")
    }

    private fun printLottoNumbers(lottos: Lottos) {
        println(lottos)
    }

    fun printResults(lottoResult: LottoResult) {
        printWinningStatistics(lottoResult)
        printRateOfReturn(lottoResult.getRateOfReturn())
    }

    private fun printWinningStatistics(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---")
        print(lottoResult)
    }

    private fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 %.1f%%입니다.".format(rateOfReturn))
    }
}