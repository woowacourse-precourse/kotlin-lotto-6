package lotto.presentation

import LOTTO_PRICE
import PURCHASE_LOTTO_COUNT_MESSAGE

object LottoGeneratorView {
    fun printPurchaseLottoCount(amount: Int) {
        println(PURCHASE_LOTTO_COUNT_MESSAGE.format(amount / LOTTO_PRICE))
    }
}