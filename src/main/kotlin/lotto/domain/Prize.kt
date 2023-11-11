package lotto.domain

class Prize {
    fun getPrizeRatio(grades: List<Grade>, money: Int): String {
        if (money == 0) {
            return "0.0"
        }
        val totalPrize = countPrize(grades)
        val ratio = calculateRatio(totalPrize, money)
        return formatRatio(ratio)
    }

    private fun countPrize(grades: List<Grade>): Long {
        return grades.sumOf { it.rewardMoney.toLong() }
    }

    private fun calculateRatio(totalPrize: Long, money: Int): Double {
        return (totalPrize.toDouble() / money.toDouble()) * 100
    }

    private fun formatRatio(ratio: Double): String {
        return String.format("%.1f", ratio)
    }

}