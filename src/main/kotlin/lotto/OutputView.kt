package lotto

import java.text.DecimalFormat
import kotlin.math.roundToInt

class OutputView {

    companion object {
        private val decimalFormat = DecimalFormat("#,###")
    }
    fun printPurchaseAmountInputMention() = println("구입금액을 입력해 주세요.")

    fun printPurchaseNumberMention(purchaseNumber: Int) = println("\n${purchaseNumber}개를 구매했습니다.")

    fun printLottoList(purchaseNumber: Int, lottoList : List<Lotto>) {
        //Thought using StringBuilder when it should be optimized.
        //val sb = StringBuilder()
        for (i in 0 until purchaseNumber) {
            //sb.append(lottoList[i].getLottoNumberString()).append('\n')
            println(lottoList[i].getLottoNumberString())
        }
        //print(sb)
    }

    fun printWinningNumberInputMention() = println("\n당첨 번호를 입력해 주세요.")

    fun printBonusNumberInputMention() = println("\n보너스 번호를 입력해 주세요.")

    fun printWinningStatisticsMention() {
        println("\n당첨 통계")
        println("---")
    }

    fun printProfitRate(rate: Double) = println("총 수익률은 ${String.format("%.1f", (rate*10).roundToInt().toDouble()/10)}%입니다.")

    fun printWinningStatics(winningList : HashMap<Int, Int>) {
        for(i in 5 downTo 1){
            println("${getWinningPrice(i).correspondResult} (${decimalFormat.format(getWinningPrice(i).price)}원) - ${winningList[i]}개")
        }
    }

    private fun getWinningPrice(rank: Int): WinningPrice {
        return when (rank) {
            5 -> WinningPrice.FIFTH
            4 -> WinningPrice.FOURTH
            3 -> WinningPrice.THIRD
            2 -> WinningPrice.SECOND
            1 -> WinningPrice.FIRST
            else -> WinningPrice.ZERO
        }
    }

}