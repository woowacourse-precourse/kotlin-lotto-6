package lotto.model

import lotto.util.Constants
import kotlin.math.round

class Profit {
    fun calculateProfit(money: Int, jackpot: List<Int>): Float {
        var profit = 0
        for ((index, value) in Rank.entries.withIndex()) {
            profit += (jackpot[index] * value.money)
        }


        return round((profit.toFloat() / money.toFloat() * 100) * 10)/10
    }
}