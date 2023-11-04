package lotto.domain

class prizeCheck {
    fun checkPrize(WINS: List<WIN>, money:Int): Double {
        val totalPrize = countPrize(WINS)
        return (totalPrize.toDouble()/money.toDouble())*100
    }

    private fun countPrize(WINS: List<WIN>) : Long {
        var totalPrize: Long = 0
        for (reward in WINS) {
            totalPrize+=reward.rewardMoney
        }
        return totalPrize
    }


}