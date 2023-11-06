package lotto.view

import lotto.domain.Lotto
import lotto.domain.Result

class OutputView {
    fun printNumberOfLottos(lottos: List<Lotto>) {
        println("\n${lottos.size}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto)
        }
    }

    fun printWinningResult(result: Result) {
        println("\n당첨 통계")
        println("---")
        print(result)
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 %.1f%%입니다.".format(rateOfReturn))
    }
}