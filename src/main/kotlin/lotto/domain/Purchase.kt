package lotto.domain

import lotto.Input
import lotto.constant.Constant
import lotto.constant.OutputMessage
import lotto.constant.Exception

class Purchase {

    //comment for starting purchase
    init {
        println(OutputMessage.MESSAGE_INPUT_PURCHASE_AMOUNT)
    }

    fun getLottoCountFromAmount(): Int {
        val amount = Input.inputAmount().toInt()
        checkValidationAmount(amount)
        return amount / Constant.PRICE_PER_LOTTO
    }

    private fun checkValidationAmount(amount: Int) {
        if(amount % 1000 != 0)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_AMOUNT)
    }
}