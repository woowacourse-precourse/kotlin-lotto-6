package lotto.domain

import lotto.model.Winning

class Calculator {

    fun calculateYield(amount : Int, reward: HashMap<Winning, Int>) : String{
        return "%.1f".format(addTotalEarnings(reward).toDouble() / amount.toDouble() * 100)
    }

    private fun addTotalEarnings(reward: HashMap<Winning, Int>): Int {

        return reward.getOrDefault(Winning.FIFTH,0) * Winning.FIFTH.reward +
                reward.getOrDefault(Winning.FOURTH,0) * Winning.FOURTH.reward +
                reward.getOrDefault(Winning.THIRD,0) * Winning.THIRD.reward +
                reward.getOrDefault(Winning.SECOND,0) * Winning.SECOND.reward +
                reward.getOrDefault(Winning.FIRST,0) * Winning.FIRST.reward
    }
}