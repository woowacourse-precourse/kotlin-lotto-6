package lotto.view

import lotto.Constants
import lotto.Constants.Companion.OUTPUT_PURCHASE_COUNT_MESSAGE

class OutputView {

    fun outputPurchaseCountMessage(ticket: Int) {
        println("\n" + String.format(OUTPUT_PURCHASE_COUNT_MESSAGE, ticket))
    }
}