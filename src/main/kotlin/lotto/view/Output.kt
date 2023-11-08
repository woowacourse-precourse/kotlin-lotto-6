package lotto.view

import lotto.model.Lotto
import lotto.model.WinningType

class Output {

    fun printWinStatics(winStatics: Map<WinningType, Int>) {
        println(WINNING_STATISTICS_MESSAGE)
        println(DIVIDER_MESSAGE)
        println(fifthWinMessage(winStatics[WinningType.FIFTH]))
        println(fourthWinMessage(winStatics[WinningType.FOURTH]))
        println(thirdWinMessage(winStatics[WinningType.THIRD]))
        println(secondWinMessage(winStatics[WinningType.SECOND]))
        println(firstWinMessage(winStatics[WinningType.FIRST]))
    }

    fun printTotalReturn(totalReturn: Int, purchaseAmount: Int) {
        val returnRate = (totalReturn.toDouble() / purchaseAmount) * 100
        val roundedRate = String.format("%.1f", returnRate)
        println(returnRateMessage(roundedRate))
    }

    fun printLottoesNum(lottoes: List<Lotto>) {
        println(purchaseNumMessage(lottoes.size))
        lottoes.forEach { lotto ->
            lotto.printLottoNumbers()
        }
    }

    companion object {
        private const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
        private const val DIVIDER_MESSAGE = "---"


        fun fifthWinMessage(num:Int?) = "3개 일치 (5,000원) - ${num}개"
        fun fourthWinMessage(num:Int?) = "4개 일치 (50,000원) - ${num}개"
        fun thirdWinMessage(num:Int?) = "5개 일치 (1,500,000원) - ${num}개"
        fun secondWinMessage(num:Int?) = "5개 일치, 보너스 볼 일치 (30,000,000원) - ${num}개"
        fun firstWinMessage(num:Int?) = "6개 일치 (2,000,000,000원) - ${num}개"

        fun returnRateMessage(returnRate: String) = "총 수익률은 $returnRate%입니다."
        fun purchaseNumMessage(purchaseNum: Int) = "${purchaseNum}개를 구매했습니다."

    }
}