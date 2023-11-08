package lotto.domain

import lotto.Constants.PRICE_OF_LOTTO

class LottoBuyer(private val budget: Int) {

    val amountOfLotto = budget / PRICE_OF_LOTTO
    val lottoList = List(amountOfLotto) {
        LottoBuilder.buildLotto()
    }
    init {
        require(budget > 0)
        require(budget % PRICE_OF_LOTTO == 0)
    }
}
