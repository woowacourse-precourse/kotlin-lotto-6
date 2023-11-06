package view

import model.Lotto

class OutputView {

    fun printPurchaseAmount() = println(RequestType.PURCHASE_AMOUNT.message)

    fun printPurchasedItemCount(count: Int) = println("${count}${RequestType.PURCHASED_N_ITEMS.message}")

    fun printLottoInfo(numbers: List<Int>) = println(numbers)

    fun printAppendLine() = println()

    fun printEnterWinningNumberMessage() = println(RequestType.ENTER_WINNING_NUMBERS.message)

    private enum class RequestType(val message: String) {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
        PURCHASED_N_ITEMS("개를 구매했습니다."),
        ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    }
}
