package lotto.domain

import lotto.utils.Constant.LOTTO_COST

class LottoGameImpl : LottoGame {

    override fun getQuantity(purchaseAmount: Int): Int = purchaseAmount / LOTTO_COST
}