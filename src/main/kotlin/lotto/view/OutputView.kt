package lotto.view

import lotto.util.PriceUtil

object OutputView {

    fun printPriceMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printLottoCountMessage(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printWinningStatisticsMessage() {
        println()
        println("당첨 통계")
        println("---")
    }

    fun printWinningResult(message: String, winningPrice: Int, winningCnt: Int) {
        println("$message (${PriceUtil.decimal.format(winningPrice)}원) - ${winningCnt}개")
    }

    fun printTotalRateOfReturnMessage(totalRateOfReturn:String){
        println("총 수익률은 ${totalRateOfReturn}%입니다.")
    }

}