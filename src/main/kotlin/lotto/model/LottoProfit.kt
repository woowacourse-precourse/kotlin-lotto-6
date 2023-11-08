package lotto.model

import FIFTH_REWARD
import FIRST_REWARD
import FOURTH_REWARD
import SECOND_REWARD
import THIRD_REWARD

class LottoProfit {
    private val rewards = listOf(
        FIRST_REWARD, SECOND_REWARD, THIRD_REWARD, FOURTH_REWARD, FIFTH_REWARD
    )

    fun calculateTotal(rank: List<Int>): Double {
        var totalReward = 0.0
        for (index in rank.indices) {
            val count = rank[index]
            val reward = rewards[index]
            totalReward += count * reward
        }

        return totalReward
    }

    fun calculateProfit(totalReward: Double, amount: Int): Double {
        val profit = (totalReward / amount) * 100.0

        return Math.round(profit * 10.0) / 10.0
    }
}