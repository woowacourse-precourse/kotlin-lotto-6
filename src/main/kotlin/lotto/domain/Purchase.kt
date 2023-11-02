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
        return amount / Constant.PRICE_PER_LOTTO
    }

    private fun checkValidationAmount(amount: Int) {
        if(amount % Constant.PRICE_PER_LOTTO != 0)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_AMOUNT)
    }

    fun getLottoNumber(lottoCount: Int) {
        while(LottoSet.countLotto() <= lottoCount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            addLottoNumber(LottoSet, lottoNumber)
        }
    }

    private fun addLottoNumber(lottoSet: LottoSet, lottoNumber: List<Int>) {
        if(checkValidationLottoNumber(lottoNumber))
            lottoSet.addLotto(Lotto(lottoNumber.sorted()))
    }

    private fun checkValidationLottoNumber(lottoNumber: List<Int>): Boolean {
        if(lottoNumber.distinct().size != lottoNumber.size)
            return false
        return true
    }


}