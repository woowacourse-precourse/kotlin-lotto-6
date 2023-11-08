package lotto.model

import kotlin.math.pow

class ProfitCalculator {
    fun calculateProfitRate(amount: Int, winPrize: Int): String {//수익률 계산
        var profitRate: Double = (winPrize.toDouble() * 100) / amount
        val saveRoundDigit = roundDigit(profitRate, 1)
        return "%.1f%%".format(saveRoundDigit)
    }

    // 반올림 함수
    fun roundDigit(number: Double, digits: Int): Double {
        return Math.round(number * 10.0.pow(digits.toDouble())) / 10.0.pow(digits.toDouble())
    }
}