package lotto.view

import lotto.Constants.MONETARY_UNIT
import lotto.domain.Winning
import java.text.DecimalFormat

enum class OutputView(val message: String) {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT_PRINT("개를 구매했습니다."),
    WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\n당첨 통계\n---")
}

fun printStartMessage() {
    println(OutputView.PURCHASE_AMOUNT.message)
}

fun printPurchaseTotal(total: Int) {
    println("\n${total/MONETARY_UNIT}" + OutputView.PURCHASE_AMOUNT_PRINT.message)
}

fun printWinningMessage() {
    println(OutputView.WINNING_NUMBER.message)
}

fun printBonusMessage() {
    println(OutputView.BONUS_NUMBER.message)
}

fun printWinningReport() {
    println(OutputView.WINNING_STATISTICS.message)
}

fun printWinningStatistics(matches: MutableList<Int>) {
    println(Winning.THREE.message + "${matches[0]}개")
    println(Winning.FOUR.message + "${matches[1]}개")
    println(Winning.FIVE.message + "${matches[2]}개")
    println(Winning.BONUS.message + "${matches[3]}개")
    println(Winning.SIX.message + "${matches[4]}개")
}

fun printEarningRate(rate: Float) {
    val decimalFormat = DecimalFormat("#.##")
    val formattedRate = decimalFormat.format(rate)
    println("총 수익률은 $formattedRate%입니다.")
}