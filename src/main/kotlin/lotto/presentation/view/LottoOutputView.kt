package lotto.presentation.view

import lotto.domain.enum.notice.Guide
import lotto.domain.model.Customer

class LottoOutputView {
    fun printInputPurchasePrice() {
        println(Guide.INPUT_PURCHASE_PRICE.notice)
    }

    fun printPurchaseCount(count: Int) {
        println("${count}${Guide.PURCHASE_COUNT.notice}")
    }

    fun printPurchaseLottosNumbers(customer: Customer){
        customer.lotteries.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printInputWinningNumbers() {
        println(Guide.INPUT_WINNING_NUMBERS.notice)
    }

    fun printInputBonusNumber() {
        println(Guide.INPUT_BONUS_NUMBER.notice)
    }

    fun printWinningStatistics(statistics: String) {
        println(Guide.WINNING_STATISTICS.notice)
        println(LINE)
        println(statistics)
    }

    fun printTotalReturnPercent(totalReturnPercent: String) {
        println(totalReturnPercent)
    }


    companion object {
        const val LINE = "---"
    }
}