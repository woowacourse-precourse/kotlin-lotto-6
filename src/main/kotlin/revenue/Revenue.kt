package revenue

class Revenue {
    val reward = Reward()

    fun calculateRateOfRevenue(ranks: List<Int>, userPrice: Int){
        var totalReward = reward.calculateReward(ranks)
        println("totalReward : $totalReward")
    }
}