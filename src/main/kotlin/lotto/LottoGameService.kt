package lotto

import lotto.Constants.Companion.ERROR_INVALID_LOTTO_AMOUNT_EXCEPTION
import lotto.Constants.Companion.LOTTO_PRICE
import lotto.Constants.Companion.MIN_NUMBER

class LottoGameService {
    fun calculateLottoPurchaseQuantity(purchaseAmount: Int): Int {
        require(purchaseAmount % LOTTO_PRICE == MIN_NUMBER){ ERROR_INVALID_LOTTO_AMOUNT_EXCEPTION }
        return purchaseAmount / LOTTO_PRICE
    }
}