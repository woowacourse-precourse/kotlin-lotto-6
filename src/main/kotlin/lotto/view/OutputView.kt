package lotto.view

class OutputView {
    companion object {
        const val PURCHASE_COUNT_STRING = "개를 구매했습니다."
        const val WINNING_STATISTICS_STRING = "당첨 통계"
        const val DASH_SEPARATOR = "---"
        const val RETURN_RATE_STRING = "총 수익률은 "

        fun printPurchaseCount(numberOfTickets: Int) {
            println("$numberOfTickets$PURCHASE_COUNT_STRING")
        }

        fun printWinningDetails() {

        }

        fun printTotalReturnRate() {

        }
    }
}
