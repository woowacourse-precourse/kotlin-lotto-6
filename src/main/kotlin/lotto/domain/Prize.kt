package lotto.domain

import kotlin.math.roundToInt

class Prize {
    fun getPrizeRatio(grades: List<Grade>, money: Int): Double {
        val totalPrize = countPrize(grades)
        val ratio = calculateRatio(totalPrize,money)
        return (ratio * 100).roundToInt() / 100.0
    }

    private fun countPrize(grades: List<Grade>): Long {
        return grades.sumOf { it.rewardMoney.toLong() }
    }

    private fun calculateRatio(totalPrize : Long, money : Int):Double{
        return (totalPrize.toDouble() / money.toDouble()) * 100
    }


}