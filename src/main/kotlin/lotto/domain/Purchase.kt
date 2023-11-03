package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Input
import lotto.constant.Constant
import lotto.constant.OutputMessage
import lotto.constant.Exception

object Purchase {

    //comment for starting purchase
    init {
        println(OutputMessage.MESSAGE_INPUT_PURCHASE_AMOUNT)
    }

    fun getLottoCountFromAmount(): Int {
        val amount = Input.inputInt()
        checkValidationAmount(amount)
        return amount.toInt() / Constant.PRICE_PER_LOTTO
    }

    private fun checkValidationAmount(amount: String) {
        if(!(amount.all { Character.isDigit(it) })) {
            println(Exception.MESSAGE_EXCEPT_DIGIT)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DIGIT)
        }
        if(amount.toInt() % Constant.PRICE_PER_LOTTO != 0) {
            println(Exception.MESSAGE_EXCEPT_AMOUNT)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_AMOUNT)
        }
    }

    fun getLottoNumber(lottoCount: Int) {
        for(i in Constant.INDEX_START ..lottoCount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            LottoSet.addLotto(Lotto(lottoNumber.sorted()))
        }
    }

}