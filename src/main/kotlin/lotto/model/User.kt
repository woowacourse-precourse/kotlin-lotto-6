package lotto.model

import lotto.util.Constant
import lotto.util.Constant.INPUT_PRICE_UNIT_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_BUY_ERROR_MESSAGE
import lotto.util.Constant.UNIT_PRICE
import lotto.util.Exception

class User(private val price : Int, private val lottoes : List<Lotto>) {

    init{
        require(price % UNIT_PRICE ==0) { INPUT_PRICE_UNIT_ERROR_MESSAGE}
        for(lotto in lottoes) {
            Exception.validateLottoNumber(lotto.getLottoNumbers())
        }
        require(price / UNIT_PRICE == lottoes.size) { LOTTO_BUY_ERROR_MESSAGE}
    }
    fun getLottoes() = lottoes

    fun getPrice() = price

}