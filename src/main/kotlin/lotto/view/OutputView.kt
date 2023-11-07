package lotto.view

import lotto.domain.model.Lottos
import lotto.domain.model.Purchase
import lotto.util.Constants

object OutputView {

    private const val PRINT_REPORT = "당첨 통계"
    private const val DIVISION_STR = "---"
    fun printLottos(purchase: Purchase, lottos: Lottos) {
        print(Constants.SPACING)
        println("${purchase.getLottoCount()}개를 구매했습니다.")
        for (lotto in lottos.lottos) {
            println(lotto.getNumbers())
        }
    }

    fun printReport(report: String) {
        print(Constants.SPACING)
        println(PRINT_REPORT)
        println(DIVISION_STR)
        println(report)
    }

    fun printPerformance() {
        val performance = TODO("수익률 계산 함수 호출")
        println("총 수익률은 $performance%입니다.")
    }
}
