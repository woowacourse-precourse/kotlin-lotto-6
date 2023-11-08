package lotto.view

enum class OutputView(val message: String) {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT_PRINT("개를 구매했습니다."),
    WINNING_NUMBER_PROMPT("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---")
}

fun printStartMessage() {
    println(OutputView.PURCHASE_AMOUNT_PROMPT)
}

fun printPurchaseTotal(total: Int) {
    println("${total}개를 구매했습니다.")
}

fun printWinningMessage() {
    println(OutputView.WINNING_NUMBER_PROMPT)
}

fun printBonusMessage() {
    println(OutputView.BONUS_NUMBER_PROMPT)
}

fun printWinningReport() {
    println(OutputView.WINNING_STATISTICS)
}

fun printEarningRate(rate: Float) {
    println("총 수익률은 {$rate}%입니다.")
}