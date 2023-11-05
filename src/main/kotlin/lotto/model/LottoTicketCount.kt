package lotto.model

import lotto.util.Constants.LOTTO_PURCHASE_COST

class LottoTicketCount(private val _purchase: String) {
    val lottoCount: Int
        get() = getLottoCount(_purchase.toInt())

    private fun getLottoCount(purchase: Int):Int {
       return  purchase / LOTTO_PURCHASE_COST
    }
}
