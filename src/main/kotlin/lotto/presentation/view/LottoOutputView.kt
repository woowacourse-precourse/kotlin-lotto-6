package lotto.presentation.view

import lotto.domain.enum.notice.Guide
import lotto.domain.model.Customer

class LottoOutputView {
    fun printInputPurchasePrice() {
        println(Guide.INPUT_PURCHASE_PRICE)
    }

    fun printPurchaseCount(count: Int) {
        println("${count}${Guide.PURCHASE_COUNT}")
    }

    fun printPurchaseLottosNumbers(customer: Customer){
        customer.lotteries.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printInputWinningNumbers() {
        println(Guide.INPUT_WINNING_NUMBERS)
    }

    fun printInputBonusNumber() {
        println(Guide.INPUT_BONUS_NUMBER)
    }

    fun printWinningStatistics(statistics: String) {
        println(Guide.WINNING_STATISTICS)
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