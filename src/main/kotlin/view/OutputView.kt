package view

object OutputView {
    private const val PLEASE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val BOUGHT_NUMBER_OF_THEM = "개를 구매했습니다."

    fun pleaseEnterPurchaseAmount() {
        println(PLEASE_ENTER_PURCHASE_AMOUNT)
    }

    fun purchasedIssuedLottoTickets(lottoPurchaseAmount: Int) {
        println("$lottoPurchaseAmount$BOUGHT_NUMBER_OF_THEM")
    }
}