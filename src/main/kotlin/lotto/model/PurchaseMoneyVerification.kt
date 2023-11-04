package lotto.model

import lotto.config.ExceptionMessage
import lotto.config.GameConfigValue

class PurchaseMoneyVerification {
    fun inputMoneyCheck(lottoPurchaseMoney:Int):Int{

        if(lottoPurchaseMoney % GameConfigValue.PURCHASE_AMOUNT_UNIT == 0){
            return lottoPurchaseMoney/GameConfigValue.PURCHASE_AMOUNT_UNIT
        }
        else{
            throw IllegalArgumentException(ExceptionMessage.UNIT_ERROR)
        }
    }


}