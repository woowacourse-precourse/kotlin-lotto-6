package lotto.model

import lotto.config.GameConfigValue.PURCHASE_AMOUNT_UNIT
import lotto.config.ExceptionMessage.UNIT_ERROR


class PurchaseMoneyVerification(private val lottoPurchaseMoney:String) {
    init {
        moneyOnlyNumberCheck()
        moneyOnlyThousand()
    }
    private fun moneyOnlyNumberCheck() {
        lottoPurchaseMoney.toIntOrNull() ?: throw IllegalArgumentException(UNIT_ERROR)
    }
    private fun moneyOnlyThousand() {
        if(lottoPurchaseMoney.toInt() % PURCHASE_AMOUNT_UNIT != 0){
            throw IllegalArgumentException(UNIT_ERROR)
        }
    }
}