package lotto.view

import lotto.constants.ErrorMessage
import lotto.constants.Strings

class OutputView {
    private val strings: Strings = Strings

    fun outputAmount() {
        println(strings.OUTPUT_PURCHASE_AMOUNT)
    }
}