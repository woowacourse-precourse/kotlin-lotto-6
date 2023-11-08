package lotto

class Profit {

    fun getProfit(stats: Map<Jackpot?, Int>, amount: String): String {
        var totalJackpot = 0.0

        stats.forEach { (jackpot, count) ->
            totalJackpot += (jackpot?.jackpot ?: 0.0) * count
        }

        val profit = (totalJackpot / amount.toDouble()) * 100

        return profit.format(1)
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)

}