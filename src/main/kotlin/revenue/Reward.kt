package revenue

class Reward {
    fun calculateReward(ranks: List<Int>): Int {
        var totalReward = 0

        for (index in 0 until ranks.size) {
            totalReward += PriceChart.values()[index].price * ranks[index]
        }

        return totalReward
    }
}