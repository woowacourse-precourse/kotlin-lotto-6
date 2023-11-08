package lotto.domain.util.validations

import lotto.domain.util.const.ErrorMessage.error_price
import lotto.domain.util.const.lottoPrice

object PriceValidator {

    fun inputPrice(lottoPurchaseAmount: String): Boolean {
        val lottoTickets = lottoPurchaseAmount.toIntOrNull()
        lottoTickets?.let {
            if (lottoTickets % lottoPrice != 0) {
                throw IllegalArgumentException(error_price)
            }
            return true
        }
        throw IllegalArgumentException(error_price)
    }

}
