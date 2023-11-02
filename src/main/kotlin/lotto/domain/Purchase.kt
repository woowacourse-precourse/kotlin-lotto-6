package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
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
        if(amount % Constant.PRICE_PER_LOTTO != 0)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_AMOUNT)
    }

    fun getLottoNumber(lottoCount: Int) {

        val lottoSet = LottoSet()

        for(i in 1..lottoCount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoSet.addLotto(Lotto(lottoNumber.sorted()))
        }
    }

}