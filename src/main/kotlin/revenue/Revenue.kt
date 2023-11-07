package revenue

class Revenue {
    val reward = Reward()

    fun calculateRateOfRevenue(ranks: List<Int>, userPrice: Int){
        var totalReward = reward.calculateReward(ranks)
        var rateOfRevenue: Double = (totalReward.toDouble() / userPrice * 100)
        val roundedRate = Math.round(rateOfRevenue * 10.0) / 10.0

        println("총 수익률은 $roundedRate%입니다.")
    }
}