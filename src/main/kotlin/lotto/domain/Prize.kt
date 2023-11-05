package lotto.domain

import kotlin.math.roundToInt

class Prize {
    fun checkPrize(grades: List<Grade>, money: Int): Double {
        val totalPrize = countPrize(grades)
        val ratio = (totalPrize.toDouble() / money.toDouble()) * 100
        return (ratio * 100).roundToInt() / 100.0
    }

    private fun countPrize(grades: List<Grade>) : Long {
        var totalPrize: Long = 0
        for (reward in grades) {
            totalPrize+=reward.rewardMoney
        }
        return totalPrize
    }


}