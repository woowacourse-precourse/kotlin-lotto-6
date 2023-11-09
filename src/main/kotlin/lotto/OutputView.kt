package lotto

import java.text.DecimalFormat
import kotlin.math.roundToInt

class OutputView {
    fun printPurchaseAmountInputMention() = println(INPUT_PURCHASE_AMOUNT_MENTION)

    fun printPurchaseNumberMention(purchaseNumber: Int) = println("\n${purchaseNumber}$OUTPUT_PURCHASE_NUMBER_MENTION.")

    fun printLottoList(purchaseNumber: Int, lottoList : List<Lotto>) {
        //Thought using StringBuilder when it should be optimized.
        //val sb = StringBuilder()
        for (i in 0 until purchaseNumber) {
            //sb.append(lottoList[i].getLottoNumberString()).append('\n')
            println(lottoList[i].getLottoNumberString())
        }
        //print(sb)
    }

    fun printWinningNumberInputMention() = println(INPUT_WINNING_NUMBER_METION)

    fun printBonusNumberInputMention() = println(INPUT_BONUS_NUMBER_MENTION)

    fun printWinningStatisticsMention() = println(OUTPUT_WINNING_STATISTICS_MENTION)

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

    companion object {
        private val decimalFormat = DecimalFormat("#,###")
        const val INPUT_PURCHASE_AMOUNT_MENTION = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBER_METION = "\n당첨 번호를 입력해 주세요."
        const val OUTPUT_PURCHASE_NUMBER_MENTION = "개를 구매했습니다."
        const val OUTPUT_WINNING_STATISTICS_MENTION = "\n당첨 통계\n---"
        const val INPUT_BONUS_NUMBER_MENTION = "\n보너스 번호를 입력해 주세요."
    }
}