package lotto.view

import lotto.domain.model.Lottos
import lotto.domain.model.Purchase
import lotto.util.Constants

object OutputView {

    private const val PRINT_REPORT = "당첨 통계"
    private const val DIVISION_STR = "---"
    private const val PRINT_PURCHASE_AMOUNT = "%d개를 구매했습니다."
    private const val PRINT_PERFORMANCE = "총 수익률은 %s%%입니다."
    fun printLottos(purchase: Purchase, lottos: Lottos) {
        print(Constants.SPACING)
        println(String.format(PRINT_PURCHASE_AMOUNT, purchase.getLottoCount()))
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

    fun printPerformance(performance: String) {
        println(String.format(PRINT_PERFORMANCE, performance))
    }
}
