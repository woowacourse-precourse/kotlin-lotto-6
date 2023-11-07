package domain.chance

import constants.Constants.LOTTO_PRICE
import domain.purchase.Money

data class Chance(val money: Money) {
    private var times = money.amount / LOTTO_PRICE

    fun getChanceTimes(): Int = times

}
