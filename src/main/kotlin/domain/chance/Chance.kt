package domain.chance

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants.LOTTO_PRICE
import lotto.domain.purchase.Money

data class Chance(val money: Money) {
    private var times = money.amount / LOTTO_PRICE

    fun getChanceTimes(): Int = times

}
