package lotto.model

import lotto.config.ExceptionMessage.UNIT_ERROR
import lotto.config.GameConfigValue.PURCHASE_AMOUNT_UNIT

class PurchaseMoneyVerification {
    fun inputMoneyCheck(lottoPurchaseMoney:Int):Int{

        if(lottoPurchaseMoney % PURCHASE_AMOUNT_UNIT == 0){
            return lottoPurchaseMoney/PURCHASE_AMOUNT_UNIT
        }
        else{
            throw IllegalArgumentException(UNIT_ERROR)
        }
    }
}