package lotto.model

import lotto.utils.ErrorMessage
import lotto.utils.Values

class LottoModel {
    fun checkPurchaseMoneyValue(moneyValue: Int): Boolean {
        try {
            if ((moneyValue % Values.LOTTERY_PRICE) != 0) {
                throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROPRIATE_VALUE}")
            }
            return false
        } catch (e: IllegalArgumentException) {
            println("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROPRIATE_VALUE}")
        }
        return true
    }

}