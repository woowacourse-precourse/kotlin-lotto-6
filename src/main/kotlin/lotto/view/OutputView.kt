package lotto.view

import lotto.domain.LottoGenerator
import lotto.domain.model.Purchase
import lotto.util.Constants

object OutputView {

    fun printReport() {
        print(Constants.SPACING)
        println(PRINT_REPORT)
        println(DIVISION_STR)
        TODO("통계 출력 함수 호출")
    }

    fun printPerformance() {
        val performance = TODO("수익률 계산 함수 호출")
        println("총 수익률은 $performance%입니다.")
    }
}
