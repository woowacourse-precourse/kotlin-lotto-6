package lotto.model

import lotto.config.ExceptionMessage.UNIT_ERROR
import lotto.config.GameConfigValue.PURCHASE_AMOUNT_UNIT

class PurchaseMoneyVerification {
    fun inputMoneyCheck(lottoPurchaseMoney:String):Int{
        val checkMoney=lottoPurchaseMoney.toIntOrNull()

        if (checkMoney != null) {
            return checkMoney / PURCHASE_AMOUNT_UNIT
        } else {
            throw IllegalArgumentException(UNIT_ERROR)
        }
    }
}