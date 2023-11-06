package lotto.model

import lotto.utils.ErrorMessage
import lotto.utils.Values

class LottoModel {
    fun checkPurchaseMoneyValueValid(moneyValue: Int): Boolean {
        return try {
            if ((moneyValue % Values.LOTTERY_PRICE) != 0) {
                throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROPRIATE_VALUE}")
            }
            false
        } catch (e: IllegalArgumentException) {
            true
        }
    }
}