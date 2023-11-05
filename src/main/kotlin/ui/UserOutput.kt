package ui

import util.Constants.MSG_OUTPUT_PURCHASE_RESULT
import util.Constants.MSG_OUTPUT_WIN_LOTTO_RESULT

object UserOutput {
    fun printPurchaseResult(count: Int) = println("$count" + MSG_OUTPUT_PURCHASE_RESULT)

    fun printWinLottoResult() = println(MSG_OUTPUT_WIN_LOTTO_RESULT)

    fun printProfitResult(profit: Double) = println("총 수익률은 ${profit}%입니다.")
}