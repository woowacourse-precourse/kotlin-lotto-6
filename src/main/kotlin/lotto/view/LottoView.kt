package lotto.view

import lotto.enums.OutPut

class LottoView {
    fun printEnterPurchaseMessage() {
        println(OutPut.PLEASE_INPUT_AMOUNT.message)
    }
}