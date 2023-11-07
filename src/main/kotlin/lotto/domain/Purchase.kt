package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Input
import lotto.constant.Constant
import lotto.constant.OutputMessage
import lotto.constant.Exception
import net.bytebuddy.pool.TypePool.Resolution.Illegal

object Purchase {

    //comment for starting purchase
    init {
        println(OutputMessage.MESSAGE_INPUT_PURCHASE_AMOUNT)
    }

    fun getLottoCountFromAmount(): Int {
        var validCheck = false
        var amount = Constant.EMPTY_STRING
        while(!validCheck) {
            amount = Input.inputInt()
            try {
                checkValidationAmount(amount)
                validCheck = true
            } catch (e: IllegalArgumentException) { }
        }
        return amount.toInt() / Constant.PRICE_PER_LOTTO
    }

    private fun checkValidationAmount(amount: String) {
        checkDigitAmount(amount)
        checkZeroAmount(amount)
        checkNumberAmount(amount)
    }

    private fun checkDigitAmount(amount: String) {
        if(!(amount.all { Character.isDigit(it) })) {
            println(Exception.MESSAGE_EXCEPT_DIGIT)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DIGIT)
        }
    }

    private fun checkZeroAmount(amount: String) {
        if(amount.toInt() == Constant.AMOUNT_IS_ZERO) {
            println(Exception.MESSAGE_EXCEPT_RANGE_AMOUNT)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_RANGE_AMOUNT)
        }
    }

    private fun checkNumberAmount(amount: String) {
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

    fun publicCheckValidationAmount(amount: String) {
        checkValidationAmount(amount)
    }
}