package lotto.util.validations

import lotto.util.lottoPrice
import lotto.util.errorPrefix

object PriceValidator {

    fun inputPrice(lottoPurchaseAmount: String): Boolean {
        val lottoTickets = lottoPurchaseAmount.toIntOrNull()
        lottoTickets?.let {
            if (lottoTickets % lottoPrice != 0) {
                throw IllegalArgumentException("$errorPrefix 구입금액은 ${lottoPrice}원 단위의 숫자 여야합니다.")
            }
            return true
        }
        throw IllegalArgumentException("$errorPrefix 구입금액은 $lottoPrice 단위의 숫자 여야합니다.")
    }

}
