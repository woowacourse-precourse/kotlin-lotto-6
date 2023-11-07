package lotto.model

import lotto.util.Constants.LOTTO_PURCHASE_COST

class LottoTicketCounter(private val _purchase: String) {
    val lottoCount: Int
        get() = getLottoCount(_purchase.toInt())

    private fun getLottoCount(purchase: Int): Int = (purchase / LOTTO_PURCHASE_COST)
}
