package lotto.view

import lotto.model.Lotto
import lotto.model.WinningType

class Output {

    fun printWinStatics(winStatics: Map<WinningType, Int>) {
        println(WINNING_STATISTICS_MESSAGE)
        println(DIVIDER_MESSAGE)
        println("$FIFTH_WIN_MESSAGE${winStatics[WinningType.FIFTH]}개")
        println("$FOURTH_WIN_MESSAGE${winStatics[WinningType.FOURTH]}개")
        println("$THIRD_WIN_MESSAGE${winStatics[WinningType.THIRD]}개")
        println("$SECOND_WIN_MESSAGE${winStatics[WinningType.SECOND]}개")
        println("$FIRST_WIN_MESSAGE${winStatics[WinningType.FIRST]}개")
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
        const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
        const val DIVIDER_MESSAGE = "---"

        const val FIFTH_WIN_MESSAGE = "3개 일치 (5,000원) - "
        const val FOURTH_WIN_MESSAGE = "4개 일치 (50,000원) - "
        const val THIRD_WIN_MESSAGE = "5개 일치 (1,500,000원) - "
        const val SECOND_WIN_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val FIRST_WIN_MESSAGE = "6개 일치 (2,000,000,000원) - "

        fun returnRateMessage(returnRate: String) = "총 수익률은 $returnRate%입니다."
        fun purchaseNumMessage(purchaseNum: Int) = "${purchaseNum}개를 구매했습니다."

    }
}