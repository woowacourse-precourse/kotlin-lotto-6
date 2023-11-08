package lotto.view

import lotto.constants.Strings

class OutputView {
    private val strings: Strings = Strings

    fun outputAmount() {
        println(strings.OUTPUT_PURCHASE_AMOUNT)
    }

    fun outputLottoCnt(cnt: Int) {
        println(strings.OUTPUT_LOTTO_COUNT.format(cnt))
    }

    fun outputBlankLine() {
        println()
    }
}