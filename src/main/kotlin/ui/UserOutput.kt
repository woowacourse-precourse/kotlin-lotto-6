package ui

const val MSG_OUTPUT_PURCHASE_RESULT = "개를 구매했습니다."
const val MSG_OUTPUT_WIN_LOTTO_RESULT = "당첨 통계\n---"

object UserOutput {
    fun printPurchaseResult(count: Int) = println("$count" + MSG_OUTPUT_PURCHASE_RESULT)

    fun printWinLottoResult() = println(MSG_OUTPUT_WIN_LOTTO_RESULT)

    fun printProfitResult(profit: Double) = println("총 수익률은 ${String.format("%.1f", profit)}%입니다.")
}