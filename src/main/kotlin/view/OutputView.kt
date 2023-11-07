package view

object OutputView {
    private const val PLEASE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val BOUGHT_NUMBER_OF_THEM = "개를 구매했습니다."
    private const val PLEASE_ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private const val PLEASE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주새요."
    private const val WINNING_STATISTICS = "당첨 통계"
    private const val THREE_DOT_LINE = "---"
    private const val WINNING_DETAIL = "당첨 내역"

    fun pleaseEnterPurchaseAmount() {
        println(PLEASE_ENTER_PURCHASE_AMOUNT)
    }

    fun purchasedIssuedLottoTickets(lottoPurchaseAmount: Int) {
        println("$lottoPurchaseAmount$BOUGHT_NUMBER_OF_THEM")
    }

    fun pleaseEnterWinningNumber() {
        println(PLEASE_ENTER_WINNING_NUMBER)
    }

    fun pleaseEnterBonusNumber() {
        println(PLEASE_ENTER_BONUS_NUMBER)
    }

    fun winningStatistics() {
        println(WINNING_STATISTICS)
    }

    fun threeDotLine() {
        println(THREE_DOT_LINE)
    }

    fun winningDetail() {
        println(WINNING_DETAIL)
    }
}
