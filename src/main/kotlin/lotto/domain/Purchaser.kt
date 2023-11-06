package lotto.domain

import lotto.Error
import lotto.util.LOTTO_PRICE

class Purchaser(money: Int) {
    val lottoCount = money / LOTTO_PRICE

    init {
        require(money >= LOTTO_PRICE && money % LOTTO_PRICE == 0) { Error.InvalidUnit.message }
    }
}