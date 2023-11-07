package lotto.view.input

import lotto.domain.LottoPurchaseAmountParser

object InputView {
    fun readPurchaseAmount(): Int {
        val input = readlnOrNull().orEmpty()
        return try {
            LottoPurchaseAmountParser.parse(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readPurchaseAmount()
        }
    }
}
