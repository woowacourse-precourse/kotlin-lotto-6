package lotto.domain

import lotto.Input.inputAmount
import lotto.constant.Constant
import lotto.constant.OutputMessage

class Purchase {

    //comment for starting purchase
    init {
        println(OutputMessage.MESSAGE_INPUT_PURCHASE_AMOUNT)
    }

    fun getLottoCountFromAmount(): Int {
        val amount = inputAmount().toInt()
        return amount / Constant.PRICE_PER_LOTTO
    }

}