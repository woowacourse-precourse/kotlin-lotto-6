package lotto.winningdetail

class Profit {

    fun getProfit(stats: Map<Jackpot?, Int>, amount: String): String {
        var totalJackpot = 0.0

        stats.forEach { (jackpot, count) ->
            totalJackpot += (jackpot?.jackpot ?: 0.0) * count
        }

        val profit = (totalJackpot / amount.toDouble()) * PERCENTAGE_CONVERSION

        return profit.format(DECIMAL_PLACE)
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)

    companion object {
        const val DECIMAL_PLACE = 1
        const val PERCENTAGE_CONVERSION = 100
    }
}