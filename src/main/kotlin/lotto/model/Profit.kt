package lotto.model

import kotlin.math.round

class Profit {
    fun calculateProfit(money: Int, jackpot: List<Int>): Float {
        var profit = 0
        profit += jackpot[0] * NumberConstants.FIVE_THOUSAND.value
        profit += jackpot[1] * NumberConstants.FIFTY_THOUSAND.value
        profit += jackpot[2] * NumberConstants.ONE_MILLION_FIVE_HUNDRED_THOUSAND.value
        profit += jackpot[3] * NumberConstants.THIRTY_MILLION.value
        profit += jackpot[4] * NumberConstants.TWO_BILLION.value

        return round(profit / money.toFloat() * NumberConstants.TEN_THOUSAND.value) / NumberConstants.HUNDRED.value
    }
}