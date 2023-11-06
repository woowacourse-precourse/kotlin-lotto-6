package lotto

import lotto.Constants.PRICE_OF_LOTTO

class LottoBuyer(private val budget: Int) {

    val amountOfLotto = budget / PRICE_OF_LOTTO
    init {
        require(budget > 0)
        require(budget % PRICE_OF_LOTTO == 0)
    }
    fun buy() = buildList<Lotto>(amountOfLotto) {
        LottoBuilder.buildLotto()
    }
}
