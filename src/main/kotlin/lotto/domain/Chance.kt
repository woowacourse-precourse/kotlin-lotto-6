package lotto.domain

import lotto.constants.Constants.LOTTO_PRICE

data class Chance(val money: Money) {
    private var times = money.amount / LOTTO_PRICE

    fun getChanceTimes(): Int = times

}
